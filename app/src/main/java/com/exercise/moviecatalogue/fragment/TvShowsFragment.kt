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
import com.exercise.moviecatalogue.adapter.TvShowsAdapter
import com.exercise.moviecatalogue.databinding.FragmentTvShowsBinding
import com.exercise.moviecatalogue.viewmodel.TvShowViewModel
import com.exercise.moviecatalogue.viewmodel.ViewModelFactory
import com.exercise.moviecatalogue.vo.Status

class TvShowsFragment : Fragment() {

    private lateinit var binding: FragmentTvShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowsAdapter = TvShowsAdapter()
            viewModel.getTvShows().observe(this, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> setProgressBar(true)
                        Status.SUCCESS -> {
                            setProgressBar(false)
                            tvShowsAdapter.setTvShows(tvShows.data)
                            tvShowsAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            setProgressBar(false)
                            Toast.makeText(context, resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }

    private fun setProgressBar(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        }
        else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}