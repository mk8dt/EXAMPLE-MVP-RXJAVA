package com.mario.core.domain.repository

import com.mario.core.domain.data.SuperHeroData

class SuperHeroCache : CacheRepository<List<SuperHeroData>>(CacheRepository.VALIDITY_LONG_TIME)