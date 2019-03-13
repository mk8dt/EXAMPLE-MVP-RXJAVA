package com.mario.superheroe.injection.component

import com.mario.superheroe.injection.ScreenScope
import com.mario.superheroe.injection.module.ScreenModule
import com.mario.superheroe.screen.superheroe.SuperHeroFragment
import com.mario.superheroe.screen.superheroe.detail.DetailFragment
import dagger.Component

@ScreenScope
@Component(dependencies = [AppComponent::class], modules = [ScreenModule::class])
interface ScreenComponent {

    fun inject(superHeroFragment: SuperHeroFragment)

    fun inject(detailFragment: DetailFragment)
}