package com.mario.superheroe.client

import com.mario.core.client.transaction.Transaction
import com.mario.core.client.transaction.TransactionRequest
import com.mario.core.client.transaction.TransactionStatus
import com.mario.superheroe.BuildConfig
import com.mario.superheroe.extension.logError
import io.reactivex.Observable
import io.reactivex.ObservableSource

class TransactionRequestImpl : TransactionRequest {

    override fun <T> wrap(observable: Observable<out T>): Observable<Transaction<T>> {
        return observable
            .map { data ->
                Transaction(data,TransactionStatus.SUCCESS)
            }
            .doOnError { throwable ->
                if (BuildConfig.DEBUG) {
                    logError(throwable)
                }
            }
            .onErrorResumeNext { throwable: Throwable ->

                ObservableSource { subscriber ->
                    subscriber.onNext(Transaction(throwable))
                    subscriber.onComplete()
                }
            }
    }

}