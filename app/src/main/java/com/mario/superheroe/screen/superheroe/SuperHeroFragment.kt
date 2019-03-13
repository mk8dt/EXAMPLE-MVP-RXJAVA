package com.mario.superheroe.screen.superheroe

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mario.superheroe.R
import com.mario.superheroe.screen.base.BaseFragment
import kotlinx.android.synthetic.main.superhero_layout.*
import javax.inject.Inject

class SuperHeroFragment : BaseFragment(), SuperHeroView {

    override lateinit var superHeroBinder: SuperHeroBinder

    @Inject
    lateinit var superHeroPresenter: SuperHeroPresenter

    companion object {
        fun newInstance(): SuperHeroFragment = SuperHeroFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.superhero_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroBinder = SuperHeroBinder(view)
        init(superHeroPresenter, this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        screen().inject(this)
    }

    override fun showErrorConnection() {
        Toast.makeText(context, getString(R.string.error_message), Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressbar.visibility = View.GONE
    }
}