package ru.nikiz.legocatalog.di

import org.koin.dsl.module
import ru.nikiz.data.repository.LegoSetRepositoryImpl
import ru.nikiz.data.repository.LegoThemeRepositoryImpl

val repositoryModule = module {
    single { LegoThemeRepositoryImpl(get(), get()) }
    single { LegoSetRepositoryImpl(get(), get()) }
}