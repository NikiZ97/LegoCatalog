package ru.nikiz.legocatalog.ui.sets


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lego_set.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.nikiz.domain.Result
import ru.nikiz.legocatalog.R
import ru.nikiz.legocatalog.extensions.showErrorMessage
import ru.nikiz.legocatalog.extensions.toggleVisibility
import ru.nikiz.legocatalog.ui.util.LegoSetItemDecoration

class LegoSetsFragment : Fragment() {

    private val args: LegoSetsFragmentArgs by navArgs()
    private val viewModel by viewModel<LegoSetsViewModel> { parametersOf(args.themeId) }
    private lateinit var adapter: LegoSetsAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    companion object {
        private const val SET_LIST_COLUMN_COUNT = 2
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lego_set, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.themeName?.let {
            (activity as AppCompatActivity).supportActionBar?.title = it
        }
        initRecyclerView()
        subscribeUi()
    }

    private fun initRecyclerView() {
        adapter = LegoSetsAdapter()
        setOnLegoSetClickListener()
        layoutManager = GridLayoutManager(context, SET_LIST_COLUMN_COUNT)
        sets.layoutManager = layoutManager
        sets.addItemDecoration(LegoSetItemDecoration(resources.getDimension(R.dimen.lego_list_item_space).toInt()))
        sets.adapter = adapter
    }

    private fun setOnLegoSetClickListener() {
        adapter.onLegoSetClickListener = { id, name, url ->
            val direction = LegoSetsFragmentDirections
                .actionLegoSetFragmentToLegoSetDetailsFragment(id, name, url)
            findNavController().navigate(direction)
        }
    }

    private fun subscribeUi() {
        viewModel.sets.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    adapter.submitList(it.data)
                    progress.toggleVisibility(false)
                }
                Result.Status.LOADING -> {
                    progress.toggleVisibility(true)
                }
                Result.Status.ERROR -> {
                    root.showErrorMessage(it.message ?: getString(R.string.unknown_error))
                    progress.toggleVisibility(false)
                }
            }
        })
    }

}
