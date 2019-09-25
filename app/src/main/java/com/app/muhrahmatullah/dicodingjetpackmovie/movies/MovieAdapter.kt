package com.app.muhrahmatullah.dicodingjetpackmovie.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.ContentItemBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieEntity
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AppExecutors
import com.app.muhrahmatullah.dicodingjetpackmovie.util.DataBoundListAdapter

/**
 * Created by muh.rahmatullah on 2019-09-26.
 */
class MovieAdapter(
    appExecutors: AppExecutors
) : DataBoundListAdapter<MovieEntity, ContentItemBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<MovieEntity>() {
        override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
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

    override fun bind(binding: ContentItemBinding, item: MovieEntity) {
        binding.movie = item
    }
}