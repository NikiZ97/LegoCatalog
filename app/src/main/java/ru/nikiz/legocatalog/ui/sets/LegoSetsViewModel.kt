package ru.nikiz.legocatalog.ui.sets

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikiz.domain.LegoSet
import ru.nikiz.domain.Result
import ru.nikiz.domain.interactor.LegoSetInteractor

class LegoSetsViewModel(private val interactor: LegoSetInteractor, themeId: Int): ViewModel() {

    lateinit var sets: LiveData<Result<List<LegoSet>>>

    init {
        viewModelScope.launch {
            sets = interactor.getSets(themeId)
        }
    }
}