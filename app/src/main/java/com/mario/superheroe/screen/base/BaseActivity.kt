package com.mario.superheroe.screen.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mario.superheroe.R
import com.mario.superheroe.injection.component.DaggerScreenComponent
import com.mario.superheroe.injection.component.ScreenComponent
import com.mario.superheroe.injection.controller.AppController
import com.mario.superheroe.injection.controller.ScreenController
import com.mario.superheroe.injection.module.ScreenModule
import com.mario.superheroe.screen.common.RouterController

abstract class BaseActivity : AppCompatActivity(), ScreenController, RouterController {

    override val screenComponent: ScreenComponent by lazy {
        DaggerScreenComponent.builder()
            .appComponent((applicationContext as AppController).appComponent)
            .screenModule(ScreenModule(this))
            .build()
    }

    override fun routeToFragment(fragment: Fragment, backStack: Boolean) {
        if (backStack) {
            supportFragmentManager.beginTransaction().replace(R.id.base_layout, fragment).addToBackStack(null).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.base_layout, fragment).commit()
        }
    }
}