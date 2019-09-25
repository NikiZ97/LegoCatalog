package ru.nikiz.data.repository

import ru.nikiz.data.dao.LegoThemeDao
import ru.nikiz.data.repository.datasource.LegoThemeRemoteDataSource
import ru.nikiz.domain.LegoCategory
import ru.nikiz.domain.repository.LegoThemeRepository

class LegoThemeRepositoryImpl(private val dao: LegoThemeDao,
                              private val remoteDataSource: LegoThemeRemoteDataSource): LegoThemeRepository {

    override suspend fun getThemes(): List<LegoCategory> {
        return listOf()
    }
}