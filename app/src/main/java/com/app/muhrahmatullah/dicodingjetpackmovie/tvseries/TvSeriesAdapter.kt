package com.app.muhrahmatullah.dicodingjetpackmovie.tvseries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.ContentItemSeriesBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.TvSeriesEntity
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AppExecutors
import com.app.muhrahmatullah.dicodingjetpackmovie.util.DataBoundListAdapter

/**
 * Created by muhrahmatullah on 2019-09-26.
 */
class TvSeriesAdapter(
    appExecutors: AppExecutors
) : DataBoundListAdapter<TvSeriesEntity, ContentItemSeriesBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<TvSeriesEntity>() {
        override fun areItemsTheSame(oldItem: TvSeriesEntity, newItem: TvSeriesEntity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: TvSeriesEntity, newItem: TvSeriesEntity): Boolean {
            return oldItem.desc == newItem.desc
        }

    }
) {
    override fun createBinding(parent: ViewGroup): ContentItemSeriesBinding {
        val binding = DataBindingUtil.inflate<ContentItemSeriesBinding>(
            LayoutInflater.from(parent.context),
            R.layout.content_item_series,
            parent,
            false
        )
        return binding
    }

    override fun bind(binding: ContentItemSeriesBinding, item: TvSeriesEntity) {
        binding.tvSeries = item
    }
}