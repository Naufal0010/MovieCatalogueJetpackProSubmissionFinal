package com.exercise.moviecatalogue.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.adapter.MovieAdapter
import com.exercise.moviecatalogue.databinding.FragmentMoviesBinding
import com.exercise.moviecatalogue.viewmodel.MovieViewModel
import com.exercise.moviecatalogue.viewmodel.ViewModelFactory
import com.exercise.moviecatalogue.vo.Status

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            viewModel.getMovies().observe(this, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> setProgressBar(true)
                        Status.SUCCESS -> {
                            setProgressBar(false)
                            movieAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            setProgressBar(false)
                            Toast.makeText(
                                context,
                                resources.getString(R.string.error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })

            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                adapter = movieAdapter
            }
        }
    }

    private fun setProgressBar(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}