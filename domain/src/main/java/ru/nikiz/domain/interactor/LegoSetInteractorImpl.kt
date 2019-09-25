package ru.nikiz.domain.interactor

import ru.nikiz.domain.LegoSet
import ru.nikiz.domain.repository.LegoSetRepository

class LegoSetInteractorImpl(private val repository: LegoSetRepository): LegoSetInteractor {
    override suspend fun getSets(): List<LegoSet> {
        return repository.getSets()
    }

}