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
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.databinding.ItemsCardviewMoviesBinding
import com.exercise.moviecatalogue.ui.DetailActivity

class FavoriteMovieAdapter :
    PagedListAdapter<MoviesModel, FavoriteMovieAdapter.FavoriteMovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val binding =
            ItemsCardviewMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FavoriteMovieAdapter.FavoriteMovieViewHolder,
        position: Int
    ) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    fun getSwipedData(swipedPosition: Int): MoviesModel? = getItem(swipedPosition)

    inner class FavoriteMovieViewHolder(private val binding: ItemsCardviewMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MoviesModel) {
            with(binding) {
                tvMoviesName.text = movie.title
                tvMoviesDetail.text = movie.description
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie.moviesId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh))
                    .error(R.drawable.ic_broken_image)
                    .into(imageViewMovies)
            }
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesModel>() {

            override fun areItemsTheSame(oldItem: MoviesModel, newItem: MoviesModel): Boolean {
                return oldItem.moviesId == newItem.moviesId
            }

            override fun areContentsTheSame(oldItem: MoviesModel, newItem: MoviesModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}