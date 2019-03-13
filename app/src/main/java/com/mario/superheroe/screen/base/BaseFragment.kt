package com.mario.superheroe.screen.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mario.superheroe.injection.component.ScreenComponent
import com.mario.superheroe.presenter.Presenter
import com.mario.superheroe.presenter.PresenterView
import io.reactivex.disposables.CompositeDisposable

open class BaseFragment : Fragment() {

    private var disposables = CompositeDisposable()

    private var presenter: Presenter<*>? = null

    fun <T : PresenterView> init(presenter: Presenter<T>, view: T) {
        this.presenter = presenter
        presenter.init(view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        disposables = CompositeDisposable()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposables.clear()
        presenter?.clear()
    }

    fun screen(): ScreenComponent {
        return (activity as BaseActivity).screenComponent
    }
}