package com.mario.superheroe.screen.superheroe

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mario.core.domain.data.SuperHeroData
import com.mario.superheroe.R
import com.mario.superheroe.extension.load
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.superhero_item_view.view.*
import kotlinx.android.synthetic.main.superhero_layout.view.*

class SuperHeroBinder(private val view: View) {

    private val superHeroAdapter = SuperHeroAdapter(listOf())
    private val onSuperHeroItemClick = PublishSubject.create<SuperHeroData>()

    init {
        view.superHero_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = superHeroAdapter
        }
    }

    fun setSuperHeroList(superheroList: List<SuperHeroData>) {
        superHeroAdapter.list = superheroList
        superHeroAdapter.notifyDataSetChanged()
    }

    fun onSuperHeroItemClicker(): Observable<SuperHeroData> {
        return onSuperHeroItemClick
    }

    inner class SuperHeroAdapter(var list: List<SuperHeroData>) : RecyclerView.Adapter<SuperHeroAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SuperHeroAdapter.Holder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.superhero_item_view, parent, false)
            return Holder(view)
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: SuperHeroAdapter.Holder, position: Int) {
            holder.drawSuperHero(list[position])
        }

        inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            init {
                itemView.setOnClickListener {
                    val position = this.adapterPosition
                    if (position != -1) {
                        onSuperHeroItemClick.onNext(list[position])
                    }
                }
            }

            fun drawSuperHero(superHeroData: SuperHeroData) {
                itemView.apply {
                    item_recycler_image.load(superHeroData.image)
                    item_recycler_name.text = superHeroData.name
                    item_recycler_real_name.text = superHeroData.realName
                }
            }
        }
    }
}