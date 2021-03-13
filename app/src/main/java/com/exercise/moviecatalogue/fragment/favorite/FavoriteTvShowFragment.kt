package com.exercise.moviecatalogue.fragment.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.databinding.FragmentFavoriteTvShowBinding


class FavoriteTvShowFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}