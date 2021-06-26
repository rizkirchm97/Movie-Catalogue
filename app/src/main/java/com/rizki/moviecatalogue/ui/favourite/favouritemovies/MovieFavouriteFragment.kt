package com.rizki.moviecatalogue.ui.favourite.favouritemovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.databinding.FragmentMovieFavouriteBinding
import com.rizki.moviecatalogue.utils.DataDummy
import com.rizki.moviecatalogue.viewmodel.ViewModelFactory

class MovieFavouriteFragment : Fragment(), MovieFavouriteFragmentCallback {
    private lateinit var binding: FragmentMovieFavouriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieFavouriteViewModel::class.java]

            val adapter = MovieFavouriteAdapter(this)
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavMovie().observe(viewLifecycleOwner, { favMovie ->
                    binding.progressBar.visibility = View.GONE
                    adapter.setFavMovies(favMovie)
                    adapter.notifyDataSetChanged()
            })

            with(binding.rvFavMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(movie: MovieEntity) {
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