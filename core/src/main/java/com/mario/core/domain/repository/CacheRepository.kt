package com.mario.core.domain.repository

import com.mario.core.client.transaction.Transaction
import com.mario.core.client.transaction.TransactionStatus
import io.reactivex.Completable
import io.reactivex.Observable

abstract class CacheRepository<T>(var validityTime: Long = VALIDITY_LONG_TIME) {

    companion object {
        const val VALIDITY_LONG_TIME = 1200000L
    }

    private var data: T? = null
    private var timestamp: Long = 0

    fun load(): Observable<Transaction<T>> {
        return Observable.create { subscriber ->
            if (data != null && isValidTime()) {
                subscriber.onNext(Transaction(data!!, TransactionStatus.SUCCESS))
            }
            subscriber.onComplete()
        }
    }

    fun save(value: T): Completable {
        return Completable.create { subscriber ->
            this.data = value
            updateTimestamp()
            subscriber.onComplete()
        }
    }

    fun clear(): Completable {
        return Completable.create { subscriber ->
            this.data = null
            subscriber.onComplete()
        }
    }

    private fun updateTimestamp() {
        timestamp = System.currentTimeMillis()
    }

    private fun isValidTime(): Boolean {
        return System.currentTimeMillis() - timestamp < validityTime
    }
}