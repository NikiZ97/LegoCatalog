package ru.nikiz.legocatalog.di

import org.koin.dsl.module
import ru.nikiz.domain.interactor.LegoSetInteractor
import ru.nikiz.domain.interactor.LegoSetInteractorImpl
import ru.nikiz.domain.interactor.LegoThemeInteractor
import ru.nikiz.domain.interactor.LegoThemeInteractorImpl

val interactorModule = module {
    factory<LegoThemeInteractor> { LegoThemeInteractorImpl(get()) }
    factory<LegoSetInteractor> { LegoSetInteractorImpl(get()) }
}