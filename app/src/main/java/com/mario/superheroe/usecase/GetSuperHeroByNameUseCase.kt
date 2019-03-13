package com.mario.superheroe.usecase

import com.mario.core.client.transaction.Transaction
import com.mario.core.domain.data.SuperHeroData
import com.mario.core.domain.service.SuperHeroService
import io.reactivex.Observable

class GetSuperHeroByNameUseCase(private val superHeroService: SuperHeroService) {

    fun getSuperHeroByName(): Observable<Transaction<SuperHeroData>> {
        return superHeroService.getSuperHeroByName()
    }
}