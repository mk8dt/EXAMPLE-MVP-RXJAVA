package com.mario.superheroe.screen.superheroe.detail

import com.mario.superheroe.presenter.PresenterView

interface DetailView : PresenterView {

    val detailBinder: DetailBinder
}