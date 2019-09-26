package ru.nikiz.domain.interactor

import androidx.lifecycle.LiveData
import ru.nikiz.domain.LegoSet
import ru.nikiz.domain.Result

interface LegoSetInteractor {
    suspend fun getSets(): LiveData<Result<List<LegoSet>>>?
}