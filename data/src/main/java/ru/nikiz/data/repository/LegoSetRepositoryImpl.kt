package ru.nikiz.data.repository

import ru.nikiz.data.dao.LegoSetDao
import ru.nikiz.data.repository.datasource.LegoSetRemoteDataSource
import ru.nikiz.domain.LegoSet
import ru.nikiz.domain.repository.LegoSetRepository

class LegoSetRepositoryImpl(private val dao: LegoSetDao,
                            private val legoSetRemoteDataSource: LegoSetRemoteDataSource): LegoSetRepository {


    override suspend fun getSets(): List<LegoSet> {
        return listOf()
    }
}