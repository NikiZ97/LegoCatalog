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
import ru.nikiz.legocatalog.ui.util.LegoSetInfo

class LegoSetsAdapter: ListAdapter<LegoSet, LegoSetsAdapter.SetViewHolder>(LegoThemeDiffCallback()) {

    lateinit var onLegoSetClickListener: LegoSetInfo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        return SetViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lego_set_item, parent, false))
    }

    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class SetViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(set: LegoSet) {
            val image = itemView.setImage
            image.clipToOutline = true
            Glide.with(itemView.context).load(set.imageUrl).into(image)
            itemView.setOnClickListener {
                onLegoSetClickListener.invoke(set.id, set.name, set.imageUrl)
            }
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