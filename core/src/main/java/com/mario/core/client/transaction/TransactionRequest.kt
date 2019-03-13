package com.mario.core.client.transaction

import io.reactivex.Observable

interface TransactionRequest {

    fun <T> wrap(observable: Observable<out T>): Observable<Transaction<T>>
}