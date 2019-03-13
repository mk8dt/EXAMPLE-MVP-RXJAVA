package com.mario.superheroe.screen.superheroe.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mario.superheroe.R
import com.mario.superheroe.screen.base.BaseFragment
import javax.inject.Inject

class DetailFragment : BaseFragment(), DetailView {

    override lateinit var detailBinder: DetailBinder

    @Inject
    lateinit var detailPresenter: DetailPresenter

    companion object {
        fun newInstance(): DetailFragment = DetailFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        screen().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.superhero_detail_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailBinder = DetailBinder(view)
        init(detailPresenter, this)
    }
}