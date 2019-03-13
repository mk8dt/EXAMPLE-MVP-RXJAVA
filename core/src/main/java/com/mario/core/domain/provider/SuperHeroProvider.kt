package com.mario.core.domain.provider

import com.mario.core.client.transaction.Transaction
import com.mario.core.client.transaction.TransactionStatus
import com.mario.core.domain.data.SuperHeroData
import com.mario.core.domain.repository.SuperHeroCache
import com.mario.core.domain.repository.SuperHeroRepository
import io.reactivex.Observable

class SuperHeroProvider(
    private val superHeroRepository: SuperHeroRepository,
    private val superHeroCache: SuperHeroCache
) {

    fun getSuperHeroList(): Observable<Transaction<List<SuperHeroData>>> {
        return superHeroCache.load().concatWith(superHeroRepository.getSuperHeroList()
            .doOnNext {
                if (it.isSuccess) {
                    superHeroCache.save(it.data!!)
                }
            }).first(Transaction(TransactionStatus.ERROR))
            .toObservable()
    }

    fun getSuperHeroByName(name: String): Observable<Transaction<SuperHeroData>> {
        return getSuperHeroList().flatMap {
            it.flatMapSuccess { list ->
                list.find { superHero ->
                    superHero.name == name
                }!!
            }
        }
    }
}