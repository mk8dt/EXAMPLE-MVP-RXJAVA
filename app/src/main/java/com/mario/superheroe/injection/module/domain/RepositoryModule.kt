package com.mario.superheroe.injection.module.domain

import com.mario.core.client.ApiClient
import com.mario.core.client.transaction.TransactionRequest
import com.mario.core.domain.repository.SuperHeroCache
import com.mario.core.domain.repository.SuperHeroRepository
import com.mario.superheroe.injection.AppScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @AppScope
    fun superHeroRepository(apiClient: ApiClient, transactionRequest: TransactionRequest) =
        SuperHeroRepository(apiClient, transactionRequest)

    @Provides
    @AppScope
    fun superHeroCache() = SuperHeroCache()
}