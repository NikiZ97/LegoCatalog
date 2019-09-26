package ru.nikiz.data.repository.datasource

import ru.nikiz.data.net.LegoService

class LegoThemeRemoteDataSource(private val apiService: LegoService): BaseDataSource() {

    suspend fun getThemes() = getResult { apiService.getCategories(1, 1000, "-id") }
}