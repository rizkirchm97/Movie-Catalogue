package com.rizki.moviecatalogue.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizki.moviecatalogue.databinding.FragmentTvShowsBinding
import com.rizki.moviecatalogue.viewmodel.ViewModelFactory
import com.rizki.moviecatalogue.vo.Status

class TvShowsFragment : Fragment() {

    private lateinit var tvShowsBinding: FragmentTvShowsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return tvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]


            val tvShowsAdapter = TvShowsFragmentAdapter()
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> tvShowsBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            tvShowsBinding.progressBar.visibility = View.GONE
                            tvShowsAdapter.setTvShows(tvShow.data)
                            tvShowsAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            tvShowsBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(tvShowsBinding.rvTvShows) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = tvShowsAdapter
            }
        }
    }
}