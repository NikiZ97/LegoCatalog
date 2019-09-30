package ru.nikiz.domain.repository

import androidx.lifecycle.LiveData
import ru.nikiz.domain.LegoSet
import ru.nikiz.domain.Result

interface LegoSetRepository {

    fun getSets(themeId: Int): LiveData<Result<List<LegoSet>>>
}