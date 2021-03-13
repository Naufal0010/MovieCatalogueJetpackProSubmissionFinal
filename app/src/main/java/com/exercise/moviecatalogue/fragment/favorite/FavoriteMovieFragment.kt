package com.exercise.moviecatalogue.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.adapter.FavoriteMovieAdapter
import com.exercise.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.exercise.moviecatalogue.viewmodel.FavoriteMovieViewModel
import com.exercise.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var adapter: FavoriteMovieAdapter
    private lateinit var viewModel: FavoriteMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding.rvMovies)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            adapter = FavoriteMovieAdapter()
            setProgressBar(true)
            viewModel.getFavoriteMovies().observe(this, { movies ->
                setProgressBar(false)
                adapter.submitList(movies)
            })

            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                adapter = this@FavoriteMovieFragment.adapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieModel = adapter.getSwipedData(swipedPosition)
                movieModel?.let { viewModel.setFavoriteMovie(it) }

                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    movieModel?.let { viewModel.setFavoriteMovie(it) }
                }
                snackbar.show()
            }
        }

    })

    private fun setProgressBar(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}