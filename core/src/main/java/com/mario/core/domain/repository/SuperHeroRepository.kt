package com.mario.core.domain.repository

import com.mario.core.client.ApiClient
import com.mario.core.client.transaction.Transaction
import com.mario.core.client.transaction.TransactionRequest
import com.mario.core.domain.data.SuperHeroData
import io.reactivex.Observable

class SuperHeroRepository(
    private val apiClient: ApiClient,
    private val transactionRequest: TransactionRequest
) {

    fun getSuperHeroList(): Observable<Transaction<List<SuperHeroData>>> {
        return transactionRequest.wrap(apiClient.getSuperHeroList())
    }
}