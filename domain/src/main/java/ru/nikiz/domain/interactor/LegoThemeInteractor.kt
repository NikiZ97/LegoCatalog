package ru.nikiz.domain.interactor

import ru.nikiz.domain.LegoCategory

interface LegoThemeInteractor {

    suspend fun getThemes(): List<LegoCategory>
}