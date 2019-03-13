package com.mario.superheroe.injection.module.usecase

import com.mario.core.domain.service.SuperHeroService
import com.mario.superheroe.injection.ScreenScope
import com.mario.superheroe.usecase.GetSuperHeroByNameUseCase
import com.mario.superheroe.usecase.GetSuperHeroListUseCase
import com.mario.superheroe.usecase.SaveNameUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    @ScreenScope
    fun getSuperHeroListUseCase(superHeroService: SuperHeroService) = GetSuperHeroListUseCase(superHeroService)

    @Provides
    @ScreenScope
    fun saveNameUseCase(superHeroService: SuperHeroService) = SaveNameUseCase(superHeroService)

    @Provides
    @ScreenScope
    fun getSuperHeroByNameUseCase(superHeroService: SuperHeroService) = GetSuperHeroByNameUseCase(superHeroService)
}