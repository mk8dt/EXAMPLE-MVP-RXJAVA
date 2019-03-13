package com.mario.superheroe.client.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SuperHeroes(
    @SerializedName("superheroes")
    @Expose
    val list: List<SuperHero>
)