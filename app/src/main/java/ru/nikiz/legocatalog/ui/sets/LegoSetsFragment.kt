package ru.nikiz.legocatalog.ui.sets


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import org.koin.android.viewmodel.ext.android.viewModel
import ru.nikiz.domain.Result
import ru.nikiz.legocatalog.R

class LegoSetsFragment : Fragment() {

    private val args: LegoSetsFragmentArgs by navArgs()
    private val viewModel by viewModel<LegoSetsViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lego_set, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.themeName?.let {
            (activity as AppCompatActivity).supportActionBar?.title = it
        }
        viewModel.themeId = args.themeId
        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.getSets()
        viewModel.sets.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    // show sets
                }
                Result.Status.LOADING -> {
                    // show loading
                }
                Result.Status.ERROR -> {
                    // show error
                }
            }
        })
    }

}
