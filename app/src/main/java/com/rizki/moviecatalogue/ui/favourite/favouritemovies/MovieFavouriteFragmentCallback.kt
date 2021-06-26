package com.rizki.moviecatalogue.ui.favourite.favouritemovies

import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity

interface MovieFavouriteFragmentCallback {

    fun onShareClick(movie: MovieEntity)
}
