package ru.nikiz.legocatalog.ui.set


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_lego_set_details.*
import ru.nikiz.legocatalog.R

class LegoSetDetailsFragment : Fragment() {

    private val args: LegoSetDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lego_set_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = (activity as AppCompatActivity)
        mainActivity.supportActionBar?.title = args.legoSetName
        mainActivity.appBarLayout.setExpanded(true)
        args.imageUrl?.let {
            Glide.with(context!!).load(it).into(setImage)
        }
    }

}
