package com.mario.superheroe.injection.module.domain

import com.mario.core.domain.provider.SuperHeroProvider
import com.mario.core.domain.repository.SuperHeroCache
import com.mario.core.domain.repository.SuperHeroRepository
import com.mario.superheroe.injection.AppScope
import dagger.Module
import dagger.Provides

@Module
class ProviderModule {

    @Provides
    @AppScope
    fun superHeroProvider(superHeroRepository: SuperHeroRepository, superHeroCache: SuperHeroCache) =
        SuperHeroProvider(superHeroRepository, superHeroCache)
}