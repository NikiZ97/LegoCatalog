package ru.nikiz.legocatalog.ui.themes

import androidx.lifecycle.ViewModel
import ru.nikiz.domain.interactor.LegoThemeInteractorImpl

class LegoThemeViewModel(logoThemeInteractor: LegoThemeInteractorImpl): ViewModel() {

    val legoThemes = logoThemeInteractor.getThemes()
}