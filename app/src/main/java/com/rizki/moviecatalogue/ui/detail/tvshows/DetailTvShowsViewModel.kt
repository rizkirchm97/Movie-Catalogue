package com.rizki.moviecatalogue.ui.detail.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.vo.Resource

class DetailTvShowsViewModel(private val appRepository: AppRepository): ViewModel() {
    val tvShowsId = MutableLiveData<String>()

    fun setSelectedTvShows(tvShowsId: String) {
        this.tvShowsId.value = tvShowsId
    }

    var tvShows: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowsId) { mTvShowId ->
        appRepository.getTvShowById(mTvShowId)
    }

    fun setFav() {
        val tvShowResource = tvShows.value
        if (tvShowResource != null) {
            val tvShowsId = tvShowResource.data

            if (tvShowsId != null) {
                val tvShowEntity = tvShowsId

                val newState = !tvShowEntity.favourite
                appRepository.setTvShowFavourite(tvShowEntity, newState)
            }
        }
    }
}