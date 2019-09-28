package com.app.muhrahmatullah.dicodingjetpackmovie.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.ContentItemBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.Entity
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AppExecutors
import com.app.muhrahmatullah.dicodingjetpackmovie.util.DataBoundListAdapter

/**
 * Created by muh.rahmatullah on 2019-09-26.
 */
class ContentAdapter(
    appExecutors: AppExecutors,
    private val repoClickCallback: ((Entity) -> Unit)?
) : DataBoundListAdapter<Entity, ContentItemBinding>(
    appExecutors = appExecutors,

    diffCallback = object : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.desc == newItem.desc
        }

    }
) {
    override fun createBinding(parent: ViewGroup): ContentItemBinding {
        val binding = DataBindingUtil.inflate<ContentItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.content_item,
            parent,
            false
        )
        return binding
    }

    override fun bind(binding: ContentItemBinding, item: Entity) {
        binding.movie = item
    }
}