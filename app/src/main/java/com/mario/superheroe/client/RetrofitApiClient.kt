package com.mario.superheroe.client

import com.mario.superheroe.client.data.SuperHeroes
import io.reactivex.Observable
import retrofit2.http.GET

interface RetrofitApiClient {

    companion object {
        const val BASE_URL = "https://api.myjson.com/"
    }

    @GET("bins/bvyob/")
    fun getSuperHeroList(): Observable<SuperHeroes>
}