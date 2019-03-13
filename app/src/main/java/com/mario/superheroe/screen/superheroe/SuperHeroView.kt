package com.mario.superheroe.screen.superheroe

import com.mario.superheroe.presenter.PresenterView

interface SuperHeroView : PresenterView {

    val superHeroBinder: SuperHeroBinder

    fun showErrorConnection()

    fun showLoading()

    fun hideLoading()
}