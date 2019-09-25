package ru.nikiz.domain.interactor

import ru.nikiz.domain.LegoSet

interface LegoSetInteractor {
    suspend fun getSets(): List<LegoSet>
}