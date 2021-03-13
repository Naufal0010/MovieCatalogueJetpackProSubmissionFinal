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
import com.exercise.moviecatalogue.adapter.FavoriteTvShowAdapter
import com.exercise.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.exercise.moviecatalogue.viewmodel.FavoriteTvShowViewModel
import com.exercise.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


class FavoriteTvShowFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvShowBinding
    private lateinit var adapter: FavoriteTvShowAdapter
    private lateinit var viewModel: FavoriteTvShowViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding.rvTvShows)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

            adapter = FavoriteTvShowAdapter()
            setProgressBar(true)
            viewModel.getFavoriteTvShows().observe(this, { tvShow ->
                setProgressBar(false)
                adapter.submitList(tvShow)
            })

            with(binding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                adapter = this@FavoriteTvShowFragment.adapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT)
        }

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowModel = adapter.getSwipedData(swipedPosition)
                tvShowModel?.let { viewModel.setFavoriteTvShow(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    tvShowModel?.let { viewModel.setFavoriteTvShow(it) }
                }
                snackbar.show()
            }
        }

    })

    private fun setProgressBar(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        }
        else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}