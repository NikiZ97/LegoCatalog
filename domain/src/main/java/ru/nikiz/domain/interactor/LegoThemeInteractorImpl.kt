package ru.nikiz.domain.interactor

import ru.nikiz.domain.LegoCategory
import ru.nikiz.domain.repository.LegoThemeRepository

class LegoThemeInteractorImpl(private val legoThemeRepository: LegoThemeRepository): LegoThemeInteractor {

    override suspend fun getThemes(): List<LegoCategory> {
        return legoThemeRepository.getThemes()
    }
}