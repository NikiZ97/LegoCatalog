package ru.nikiz.data.repository.datasource

import ru.nikiz.data.net.LegoService

class LegoSetRemoteDataSource(private val apiService: LegoService): BaseDataSource() {

    suspend fun getSetsByThemeId(themeId: Int) =
        getResult { apiService.getSets(1, 100, themeId, "-id") }
}