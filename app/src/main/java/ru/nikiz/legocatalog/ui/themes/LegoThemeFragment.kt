package ru.nikiz.legocatalog.ui.themes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_lego_theme.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.nikiz.data.extensions.toggleVisibility
import ru.nikiz.domain.Result
import ru.nikiz.legocatalog.R
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
            resources.getDimension(R.dimen.lego_theme_list_item_space).toInt()
        ))
        legoThemes.adapter = themeAdapter
        subscribeUi()
    }

    private fun subscribeUi() {
        legoThemeViewModel.legoThemes.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.ERROR -> {
                    progress.toggleVisibility(false)
                    Toast.makeText(context, "Error: ${result.message}", Toast.LENGTH_LONG).show()
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
