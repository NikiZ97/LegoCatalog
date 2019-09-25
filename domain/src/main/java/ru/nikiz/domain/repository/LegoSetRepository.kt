package ru.nikiz.domain.repository

import ru.nikiz.domain.LegoSet

interface LegoSetRepository {

    suspend fun getSets(): List<LegoSet>
}