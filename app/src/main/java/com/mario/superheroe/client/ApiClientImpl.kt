package com.mario.superheroe.client

import com.mario.core.client.ApiClient
import com.mario.core.domain.data.SuperHeroData
import com.mario.superheroe.client.data.SuperHero
import io.reactivex.Observable

class ApiClientImpl(private val retrofitApiClient: RetrofitApiClient) : ApiClient {

    override fun getSuperHeroList(): Observable<List<SuperHeroData>> {
        return retrofitApiClient.getSuperHeroList().map { superHero ->
            superHero.list.map { SuperHero(it.name, it.image, it.realName, it.height, it.power, it.abilities, it.group) }
        }
    }
}