package ru.nikiz.legocatalog.ui.themes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lego_theme_item.view.*
import ru.nikiz.domain.LegoCategory
import ru.nikiz.legocatalog.R

class LegoThemesAdapter: ListAdapter<LegoCategory, LegoThemesAdapter.ThemeViewHolder>(LegoThemeDiffCallback()) {

    lateinit var onThemeClickListener: (Int, String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        return ThemeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lego_theme_item, parent, false))
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ThemeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(category: LegoCategory) {
            itemView.themeName.text = category.name
            itemView.setOnClickListener {
                onThemeClickListener.invoke(category.id, category.name)
            }
        }
    }


    class LegoThemeDiffCallback: DiffUtil.ItemCallback<LegoCategory>() {
        override fun areItemsTheSame(oldItem: LegoCategory, newItem: LegoCategory): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LegoCategory, newItem: LegoCategory): Boolean {
            return oldItem.name == newItem.name
        }

    }
}