package com.mario.superheroe.injection.module

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import com.mario.superheroe.SuperHeroApp
import com.mario.superheroe.injection.AppScope
import com.mario.superheroe.injection.module.client.ApiModule
import com.mario.superheroe.injection.module.domain.ProviderModule
import com.mario.superheroe.injection.module.domain.RepositoryModule
import com.mario.superheroe.injection.module.domain.ServiceModule
import com.mario.superheroe.injection.module.usecase.UseCaseModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [ServiceModule::class,
        ProviderModule::class,
        RepositoryModule::class,
        ApiModule::class,
        UseCaseModule::class]
)
class AppModule(private val app: SuperHeroApp) {

    @Provides
    @AppScope
    fun resources(): Resources = app.resources

    @Provides
    @AppScope
    fun context(): Context = app.applicationContext
}