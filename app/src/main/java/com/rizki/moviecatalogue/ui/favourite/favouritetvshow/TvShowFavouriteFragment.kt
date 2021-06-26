package com.rizki.moviecatalogue.ui.favourite.favouritetvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.databinding.FragmentTvShowFavouriteBinding
import com.rizki.moviecatalogue.ui.favourite.favouritemovies.MovieFavouriteAdapter
import com.rizki.moviecatalogue.utils.DataDummy
import com.rizki.moviecatalogue.viewmodel.ViewModelFactory

class TvShowFavouriteFragment : Fragment(), TvShowFavouriteFragmentCallback {

    private lateinit var binding: FragmentTvShowFavouriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowFavouriteViewModel::class.java]

            val adapter = TvShowFavouriteAdapter(this)
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavTvShow().observe(viewLifecycleOwner, { favTvShow ->
                binding.progressBar.visibility = View.GONE
                adapter.setFavTvShow(favTvShow)
                adapter.notifyDataSetChanged()
            })

            with(binding.rvFavTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(movie: TvShowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan Aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, movie.title))
                .startChooser()
        }
    }

}