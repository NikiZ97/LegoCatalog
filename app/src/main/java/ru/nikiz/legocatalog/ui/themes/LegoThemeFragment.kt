package ru.nikiz.legocatalog.ui.themes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_lego_theme.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.nikiz.domain.Result
import ru.nikiz.legocatalog.R
import ru.nikiz.legocatalog.extensions.showErrorMessage
import ru.nikiz.legocatalog.extensions.toggleVisibility
import ru.nikiz.legocatalog.ui.util.LegoThemeItemDecoration

class LegoThemeFragment : Fragment() {

    private val legoThemeViewModel by viewModel<LegoThemeViewModel>()
    private lateinit var themeAdapter: LegoThemesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lego_theme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        themeAdapter = LegoThemesAdapter()
        legoThemes.layoutManager = LinearLayoutManager(context)
        legoThemes.addItemDecoration(LegoThemeItemDecoration(
            resources.getDimension(R.dimen.lego_list_item_space).toInt()
        ))
        setOnThemeClickListener()
        legoThemes.adapter = themeAdapter
        subscribeUi()
    }

    private fun setOnThemeClickListener() {
        themeAdapter.onThemeClickListener = { themeId, themeName ->
            val direction = LegoThemeFragmentDirections
                .actionLegoThemeFragmentToLegoSetFragment(themeId, themeName)
            findNavController().navigate(direction)
        }
    }

    private fun subscribeUi() {
        legoThemeViewModel.legoThemes.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.ERROR -> {
                    progress.toggleVisibility(false)
                    root.showErrorMessage(result.message
                        ?: getString(R.string.unknown_error))
                }
                Result.Status.LOADING -> {
                    progress.toggleVisibility(true)
                }
                Result.Status.SUCCESS -> {
                    progress.toggleVisibility(false)
                    themeAdapter.submitList(result.data)
                }
            }
        })
    }
}
