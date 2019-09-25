package ru.nikiz.domain.repository

import ru.nikiz.domain.LegoCategory

interface LegoThemeRepository {

    suspend fun getThemes(): List<LegoCategory>
}