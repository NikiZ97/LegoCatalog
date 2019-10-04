package ru.nikiz.legocatalog.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nikiz.legocatalog.ui.sets.LegoSetsViewModel
import ru.nikiz.legocatalog.ui.themes.LegoThemeViewModel

val viewModelModule = module {
    viewModel { LegoThemeViewModel(get()) }
    viewModel { (themeId: Int) -> LegoSetsViewModel(get(), themeId) }
}