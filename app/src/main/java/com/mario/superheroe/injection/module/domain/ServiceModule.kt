package com.mario.superheroe.injection.module.domain

import com.mario.core.domain.provider.SuperHeroProvider
import com.mario.core.domain.service.SuperHeroService
import com.mario.superheroe.injection.AppScope
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    @AppScope
    fun superHeroService(superHeroProvider: SuperHeroProvider) = SuperHeroService(superHeroProvider)
}