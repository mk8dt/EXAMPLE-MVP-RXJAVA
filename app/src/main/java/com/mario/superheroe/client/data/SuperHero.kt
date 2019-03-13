package com.mario.superheroe.client.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mario.core.domain.data.SuperHeroData

data class SuperHero(
    @SerializedName("name")
    @Expose
    override var name: String,
    @SerializedName("photo")
    @Expose
    override var image: String,
    @SerializedName("realName")
    @Expose
    override var realName: String,
    @SerializedName("height")
    @Expose
    override var height: String,
    @SerializedName("power")
    @Expose
    override var power: String,
    @SerializedName("abilities")
    @Expose
    override var abilities: String,
    @SerializedName("groups")
    @Expose
    override var group: String
) : SuperHeroData