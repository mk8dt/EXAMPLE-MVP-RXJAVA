package com.mario.superheroe.screen.superheroe

import com.mario.superheroe.extension.throttleDefault
import com.mario.superheroe.presenter.Presenter
import com.mario.superheroe.screen.common.RouterController
import com.mario.superheroe.screen.superheroe.detail.DetailFragment
import com.mario.superheroe.usecase.GetSuperHeroListUseCase
import com.mario.superheroe.usecase.SaveNameUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SuperHeroPresenter @Inject constructor(
    private val getSuperHeroListUseCase: GetSuperHeroListUseCase,
    private val saveNameUseCase: SaveNameUseCase,
    private val routerController: RouterController
) : Presenter<SuperHeroView>() {

    override fun init() {
        view?.showLoading()
        addSubscription(
            getSuperHeroListUseCase.getSuperHeroList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view?.hideLoading()
                    if (it.isSuccess) {
                        view?.superHeroBinder!!.setSuperHeroList(it.data!!)
                    } else {
                        view?.showErrorConnection()
                    }
                }
        )

        addSubscription(
            view?.superHeroBinder!!.onSuperHeroItemClicker().throttleDefault()
                .subscribe {
                    saveNameUseCase.saveSuperHeroName(it.name)
                    routerController.routeToFragment(DetailFragment.newInstance(), true)
                }
        )
    }
}