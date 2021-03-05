package com.exercise.moviecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.databinding.ItemsCardviewMoviesBinding
import com.exercise.moviecatalogue.ui.DetailActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<MoviesModel>()

    fun setMovies(movies: List<MoviesModel>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemsCardviewMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MovieViewHolder(private val binding: ItemsCardviewMoviesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind (movie: MoviesModel) {
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
}