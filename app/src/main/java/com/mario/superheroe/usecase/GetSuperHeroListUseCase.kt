package com.mario.superheroe.usecase

import com.mario.core.client.transaction.Transaction
import com.mario.core.domain.data.SuperHeroData
import com.mario.core.domain.service.SuperHeroService
import io.reactivex.Observable

class GetSuperHeroListUseCase(
    private val superHeroService: SuperHeroService) {

    fun getSuperHeroList(): Observable<Transaction<List<SuperHeroData>>> {
        return superHeroService.getSuperHeroList()
    }
}