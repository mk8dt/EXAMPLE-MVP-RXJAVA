package com.mario.superheroe.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class Presenter<V : PresenterView> {

    private var compositeDisposable: CompositeDisposable? = null
    protected var view: V? = null

    fun init(presenterView: V) {
        view = presenterView
        compositeDisposable = CompositeDisposable()
        init()
    }

    fun clear() {
        view = null
        compositeDisposable?.dispose()
    }

    protected fun addSubscription(disposable: Disposable) {
        compositeDisposable!!.add(disposable)
    }

    protected abstract fun init()
}