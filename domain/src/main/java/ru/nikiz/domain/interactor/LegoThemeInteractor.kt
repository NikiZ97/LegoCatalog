package ru.nikiz.domain.interactor

import androidx.lifecycle.LiveData
import ru.nikiz.domain.LegoCategory
import ru.nikiz.domain.Result

interface LegoThemeInteractor {
    fun getThemes(): LiveData<Result<List<LegoCategory>>>
}