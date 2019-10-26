package com.app.muhrahmatullah.dicodingjetpackmovie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.ContentItemBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.Entity
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.Result
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AppExecutors
import com.app.muhrahmatullah.dicodingjetpackmovie.util.DataBoundListAdapter

/**
 * Created by muh.rahmatullah on 2019-09-26.
 */
class ContentAdapter(
    appExecutors: AppExecutors,
    private val itemClickCallback: ((Result, ImageView, TextView) -> Unit)?
) : DataBoundListAdapter<Result, ContentItemBinding>(
    appExecutors = appExecutors,

    diffCallback = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.title == newItem.title
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

        binding.root.setOnClickListener {
            binding.movie?.let {
                itemClickCallback?.invoke(it, binding.posterImg, binding.tvTitle)
            }
        }

        return binding
    }

    override fun bind(binding: ContentItemBinding, item: Result) {
        binding.movie = item
    }
}