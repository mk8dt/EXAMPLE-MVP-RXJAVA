package com.mario.core.client.transaction

import io.reactivex.Observable
import io.reactivex.ObservableSource

class Transaction<T> {

    var data: T? = null
    var status: TransactionStatus? = null
        private set
    var throwable: Throwable? = null
        private set

    constructor(status: TransactionStatus) {
        this.status = status
    }

    constructor(throwable: Throwable?) {
        this.status = TransactionStatus.ERROR
        this.throwable = throwable
    }

    constructor(data: T, status: TransactionStatus) {
        this.data = data
        this.status = status
    }

    val isSuccess: Boolean
        get() = status == TransactionStatus.SUCCESS

    private fun <R> mapSuccess(function: (T) -> R): Transaction<R> {
        return if (isSuccess) {
            Transaction(function(data!!), TransactionStatus.SUCCESS)
        } else {
            mapError()
        }
    }

    private fun <T> mapError(): Transaction<T> {
        return Transaction(throwable)
    }

    fun <R> flatMapSuccess(function: (T) -> R): Observable<Transaction<R>> {
        return Observable.create<Transaction<R>> {
            it.onNext(mapSuccess(function))
        }.onErrorResumeNext { throwable: Throwable ->
            ObservableSource { subscriber ->
                subscriber.onNext(Transaction(throwable))
                subscriber.onComplete()
            }
        }
    }
}