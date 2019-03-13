package com.mario.superheroe.screen.superheroe

import android.os.Bundle
import com.mario.superheroe.R
import com.mario.superheroe.screen.base.BaseActivity

class SuperHeroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_layout)
        routeToFragment(SuperHeroFragment.newInstance())
    }
}