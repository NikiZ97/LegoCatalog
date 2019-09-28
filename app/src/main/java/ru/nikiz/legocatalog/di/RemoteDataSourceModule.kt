package ru.nikiz.legocatalog.di

import org.koin.dsl.module
import ru.nikiz.data.repository.datasource.LegoSetRemoteDataSource
import ru.nikiz.data.repository.datasource.LegoThemeRemoteDataSource

val remoteDataSource = module {
    factory { LegoThemeRemoteDataSource(get()) }
    factory { LegoSetRemoteDataSource(get()) }
}