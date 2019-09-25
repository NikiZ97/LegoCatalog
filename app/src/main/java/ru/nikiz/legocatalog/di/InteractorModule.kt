package ru.nikiz.legocatalog.di

import org.koin.dsl.module
import ru.nikiz.domain.interactor.LegoSetInteractorImpl
import ru.nikiz.domain.interactor.LegoThemeInteractorImpl

val interactorModule = module {
    factory { LegoThemeInteractorImpl(get()) }
    factory { LegoSetInteractorImpl(get()) }
}