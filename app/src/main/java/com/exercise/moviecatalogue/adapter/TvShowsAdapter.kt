package com.exercise.moviecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.databinding.ItemsCardviewTvshowsBinding
import com.exercise.moviecatalogue.ui.DetailActivity

class TvShowsAdapter :
    PagedListAdapter<TvShowsModel, TvShowsAdapter.TvShowsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val binding =
            ItemsCardviewTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class TvShowsViewHolder(private val binding: ItemsCardviewTvshowsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShowsModel) {
            with(binding) {
                tvTvshowsName.text = tvShow.title
                tvTvshowsDetail.text = tvShow.description
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tvShow.tvShowsId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh))
                    .error(R.drawable.ic_broken_image)
                    .into(imageViewTvshows)
            }
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowsModel>() {

            override fun areItemsTheSame(oldItem: TvShowsModel, newItem: TvShowsModel): Boolean {
                return oldItem.tvShowsId == newItem.tvShowsId
            }

            override fun areContentsTheSame(oldItem: TvShowsModel, newItem: TvShowsModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}