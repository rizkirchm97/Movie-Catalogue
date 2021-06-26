package com.rizki.moviecatalogue.ui.favourite.favouritetvshow

import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity

interface TvShowFavouriteFragmentCallback {
    fun onShareClick(movie: TvShowEntity)
}
