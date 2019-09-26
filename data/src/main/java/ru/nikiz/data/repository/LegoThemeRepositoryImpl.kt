package ru.nikiz.data.repository

import androidx.lifecycle.LiveData
import ru.nikiz.data.dao.LegoThemeDao
import ru.nikiz.data.repository.datasource.LegoThemeRemoteDataSource
import ru.nikiz.data.resultLiveData
import ru.nikiz.domain.LegoCategory
import ru.nikiz.domain.Result
import ru.nikiz.domain.repository.LegoThemeRepository

class LegoThemeRepositoryImpl(private val dao: LegoThemeDao,
                              private val remoteDataSource: LegoThemeRemoteDataSource): LegoThemeRepository {

    override fun getThemes(): LiveData<Result<List<LegoCategory>>>{
        return resultLiveData(
            { dao.getThemesFromDb() },
            { remoteDataSource.getThemes() },
            { dao.insertAllThemes(it.results) })
    }
}