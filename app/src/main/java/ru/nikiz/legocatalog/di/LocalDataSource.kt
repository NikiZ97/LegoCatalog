package ru.nikiz.legocatalog.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.nikiz.data.AppDatabase

val localDataSourceModule = module {
    single { AppDatabase.buildDatabase(androidContext()) }
    single { get<AppDatabase>().legoThemeDao() }
    single { get<AppDatabase>().legoSetDao() }
}