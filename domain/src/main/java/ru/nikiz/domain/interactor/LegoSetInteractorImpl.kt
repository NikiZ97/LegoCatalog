package ru.nikiz.domain.interactor

import androidx.lifecycle.LiveData
import ru.nikiz.domain.LegoSet
import ru.nikiz.domain.Result
import ru.nikiz.domain.repository.LegoSetRepository

class LegoSetInteractorImpl(private val repository: LegoSetRepository): LegoSetInteractor {
    override suspend fun getSets(): LiveData<Result<List<LegoSet>>>? {
        return null
    }

}