package com.rizki.moviecatalogue.ui.favourite.favouritetvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.utils.DataDummy

class TvShowFavouriteViewModel(private val appRepository: AppRepository): ViewModel() {

    fun getFavTvShow(): LiveData<List<TvShowEntity>> = appRepository.getTvShowFavourite()
}