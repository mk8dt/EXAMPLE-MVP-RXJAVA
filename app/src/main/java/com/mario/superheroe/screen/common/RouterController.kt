package com.mario.superheroe.screen.common

import android.support.v4.app.Fragment

interface RouterController {

    fun routeToFragment(fragment: Fragment, backStack: Boolean = false)
}