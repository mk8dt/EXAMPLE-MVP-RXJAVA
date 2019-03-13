package com.mario.superheroe.injection.module.client

import com.mario.core.client.ApiClient
import com.mario.core.client.transaction.TransactionRequest
import com.mario.superheroe.client.ApiClientImpl
import com.mario.superheroe.client.RetrofitApiClient
import com.mario.superheroe.client.TransactionRequestImpl
import com.mario.superheroe.injection.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    @AppScope
    fun gsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @AppScope
    fun retrofitApiBuilder(gsonConverterFactory: GsonConverterFactory): RetrofitApiClient {
        return Retrofit.Builder()
            .baseUrl(RetrofitApiClient.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RetrofitApiClient::class.java)
    }

    @Provides
    @AppScope
    fun apiClient(retrofitApiClient: RetrofitApiClient): ApiClient {
        return ApiClientImpl(retrofitApiClient)
    }

    @Provides
    @AppScope
    fun transactionRequest(): TransactionRequest {
        return TransactionRequestImpl()
    }
}