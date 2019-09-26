package ru.nikiz.domain.interactor

import androidx.lifecycle.LiveData
import ru.nikiz.domain.LegoCategory
import ru.nikiz.domain.Result
import ru.nikiz.domain.repository.LegoThemeRepository

class LegoThemeInteractorImpl(private val legoThemeRepository: LegoThemeRepository): LegoThemeInteractor {


    override fun getThemes(): LiveData<Result<List<LegoCategory>>> {
        return legoThemeRepository.getThemes()
    }

}