package ru.nikiz.domain.repository

import androidx.lifecycle.LiveData
import ru.nikiz.domain.LegoCategory
import ru.nikiz.domain.Result

interface LegoThemeRepository {

    fun getThemes(): LiveData<Result<List<LegoCategory>>>
}