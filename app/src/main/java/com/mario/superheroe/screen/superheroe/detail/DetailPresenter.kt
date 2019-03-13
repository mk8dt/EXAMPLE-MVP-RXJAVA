package com.mario.superheroe.screen.superheroe.detail

import com.mario.superheroe.presenter.Presenter
import com.mario.superheroe.usecase.GetSuperHeroByNameUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val getSuperHeroByNameUseCase: GetSuperHeroByNameUseCase
) : Presenter<DetailView>() {

    override fun init() {
        addSubscription(
            getSuperHeroByNameUseCase.getSuperHeroByName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isSuccess) {
                        view?.detailBinder!!.drawSuperHeroeData(it.data!!)
                    } else {

                    }
                }

        )
    }
}