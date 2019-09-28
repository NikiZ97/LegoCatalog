package ru.nikiz.legocatalog.di

import org.koin.dsl.module
import ru.nikiz.data.repository.LegoSetRepositoryImpl
import ru.nikiz.data.repository.LegoThemeRepositoryImpl
import ru.nikiz.domain.repository.LegoSetRepository
import ru.nikiz.domain.repository.LegoThemeRepository

val repositoryModule = module {
    single<LegoThemeRepository> { LegoThemeRepositoryImpl(get(), get()) }
    single<LegoSetRepository> { LegoSetRepositoryImpl(get(), get()) }
}