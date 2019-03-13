package com.mario.superheroe.injection.module

import com.mario.superheroe.injection.ScreenScope
import com.mario.superheroe.injection.controller.ScreenController
import com.mario.superheroe.injection.module.usecase.UseCaseModule
import com.mario.superheroe.screen.base.BaseActivity
import com.mario.superheroe.screen.common.RouterController
import dagger.Module
import dagger.Provides

@Module(includes = [UseCaseModule::class])
class ScreenModule(private val activity: BaseActivity) {

    @Provides
    @ScreenScope
    fun screenController(): ScreenController = activity

    @Provides
    @ScreenScope
    fun routerController(): RouterController = activity

}