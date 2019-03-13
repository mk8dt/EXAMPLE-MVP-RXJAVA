package com.mario.superheroe.injection.component

import android.content.Context
import android.content.res.Resources
import com.mario.core.domain.service.SuperHeroService
import com.mario.superheroe.injection.AppScope
import com.mario.superheroe.injection.module.AppModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun provideContext(): Context

    fun providerResources(): Resources

    fun provideSuperHeroService(): SuperHeroService
}