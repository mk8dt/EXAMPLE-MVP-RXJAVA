package com.mario.superheroe

import android.app.Application
import com.mario.superheroe.injection.component.AppComponent
import com.mario.superheroe.injection.component.DaggerAppComponent
import com.mario.superheroe.injection.controller.AppController
import com.mario.superheroe.injection.module.AppModule

class SuperHeroApp : Application(), AppController {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}