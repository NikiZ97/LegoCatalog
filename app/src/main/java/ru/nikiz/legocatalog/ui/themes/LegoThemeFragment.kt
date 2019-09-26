package ru.nikiz.legocatalog.ui.themes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel
import ru.nikiz.domain.Result
import ru.nikiz.legocatalog.R

class LegoThemeFragment : Fragment() {

    private val legoThemeViewModel by viewModel<LegoThemeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lego_theme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
    }

    private fun subscribeUi() {
        legoThemeViewModel.legoThemes.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.ERROR -> {
                    // show error
                }
                Result.Status.LOADING -> {
                    // show loading
                }
                Result.Status.SUCCESS -> {
                    // show themes
                }
            }
        })
    }
}
