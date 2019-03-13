package com.mario.core.client

import com.mario.core.domain.data.SuperHeroData
import io.reactivex.Observable

interface ApiClient {

    fun getSuperHeroList() : Observable<List<SuperHeroData>>
}