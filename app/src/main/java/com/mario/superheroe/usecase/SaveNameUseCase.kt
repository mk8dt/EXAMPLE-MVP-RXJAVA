package com.mario.superheroe.usecase

import com.mario.core.domain.service.SuperHeroService

class SaveNameUseCase(private val superHeroService: SuperHeroService) {

    fun saveSuperHeroName(name: String) {
        superHeroService.saveSuperHeroName(name)
    }
}