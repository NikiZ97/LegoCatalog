package ru.nikiz.data.repository

import androidx.lifecycle.LiveData
import ru.nikiz.data.dao.LegoSetDao
import ru.nikiz.data.repository.datasource.LegoSetRemoteDataSource
import ru.nikiz.data.resultLiveData
import ru.nikiz.domain.LegoSet
import ru.nikiz.domain.Result
import ru.nikiz.domain.repository.LegoSetRepository

class LegoSetRepositoryImpl(private val dao: LegoSetDao,
                            private val legoSetRemoteDataSource: LegoSetRemoteDataSource): LegoSetRepository {


    override fun getSets(themeId: Int): LiveData<Result<List<LegoSet>>> {
        return resultLiveData(
            { dao.getSets() },
            { legoSetRemoteDataSource.getSetsByThemeId(themeId) },
            { dao.insertAllSets(it.results) })
    }
}