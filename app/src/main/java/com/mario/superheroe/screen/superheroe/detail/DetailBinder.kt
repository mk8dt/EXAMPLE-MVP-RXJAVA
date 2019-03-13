package com.mario.superheroe.screen.superheroe.detail

import android.view.View
import com.mario.core.domain.data.SuperHeroData
import com.mario.superheroe.extension.load
import kotlinx.android.synthetic.main.superhero_detail_layout.view.*

class DetailBinder(private val view: View) {

    fun drawSuperHeroeData(superHeroData: SuperHeroData) {
        view.apply {
            image_superhero_detail.load(superHeroData.image)
            name_superhero_detail.text = superHeroData.name
            realname_superhero_detail.text = superHeroData.realName
            height_superhero_detail.text = superHeroData.height
            abilities_superhero_detail.text = superHeroData.abilities
            power_superhero_detail.text = superHeroData.power
            group_superhero_detail.text = superHeroData.group
        }
    }
}