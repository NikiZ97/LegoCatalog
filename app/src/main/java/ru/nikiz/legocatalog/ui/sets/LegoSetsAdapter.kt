package ru.nikiz.legocatalog.ui.sets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.lego_set_item.view.*
import ru.nikiz.domain.LegoSet
import ru.nikiz.legocatalog.R

class LegoSetsAdapter: ListAdapter<LegoSet, LegoSetsAdapter.SetViewHolder>(LegoThemeDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        return SetViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lego_set_item, parent, false))
    }

    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {
        val set = getItem(position)
        holder.bind(getItem(position), clickListener(set.id, set.name))
    }

    private fun clickListener(id: String, name: String): View.OnClickListener {
        return View.OnClickListener {
//            val direction = LegoThemeFragmentDirections
//                .actionLegoThemeFragmentToLegoSetFragment(id, name)
//            it.findNavController().navigate(direction)
        }
    }


    class SetViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(set: LegoSet, listener: View.OnClickListener) {
            val image = itemView.setImage
            image.clipToOutline = true
            Glide.with(itemView.context).load(set.imageUrl).into(image)
            itemView.setOnClickListener(listener)
        }
    }


    class LegoThemeDiffCallback: DiffUtil.ItemCallback<LegoSet>() {
        override fun areItemsTheSame(oldItem: LegoSet, newItem: LegoSet): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LegoSet, newItem: LegoSet): Boolean {
            return oldItem.imageUrl == oldItem.imageUrl
        }

    }
}