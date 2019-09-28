package ru.nikiz.legocatalog.ui.themes

import androidx.lifecycle.ViewModel
import ru.nikiz.domain.interactor.LegoThemeInteractor

class LegoThemeViewModel(logoThemeInteractor: LegoThemeInteractor): ViewModel() {

    val legoThemes = logoThemeInteractor.getThemes()
}