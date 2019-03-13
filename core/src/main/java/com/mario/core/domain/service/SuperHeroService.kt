package com.mario.core.domain.service

import com.mario.core.client.transaction.Transaction
import com.mario.core.domain.data.SuperHeroData
import com.mario.core.domain.provider.SuperHeroProvider
import io.reactivex.Observable

class SuperHeroService(private val superHeroProvider: SuperHeroProvider) {

    var data: String? = null

    fun getSuperHeroList(): Observable<Transaction<List<SuperHeroData>>> {
        return superHeroProvider.getSuperHeroList()
    }

    fun saveSuperHeroName(name: String) {
        data = name
    }

    fun getSuperHeroByName(): Observable<Transaction<SuperHeroData>> {
        return superHeroProvider.getSuperHeroByName(data!!)
    }
}