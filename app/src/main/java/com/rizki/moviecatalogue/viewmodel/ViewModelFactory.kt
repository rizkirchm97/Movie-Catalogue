package com.rizki.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.di.Injection
import com.rizki.moviecatalogue.ui.detail.movies.DetailMoviesViewModel
import com.rizki.moviecatalogue.ui.detail.tvshows.DetailTvShowsViewModel
import com.rizki.moviecatalogue.ui.favourite.favouritemovies.MovieFavouriteViewModel
import com.rizki.moviecatalogue.ui.favourite.favouritetvshow.TvShowFavouriteViewModel
import com.rizki.moviecatalogue.ui.movies.MoviesViewModel
import com.rizki.moviecatalogue.ui.tvshows.TvShowsViewModel

class ViewModelFactory private constructor(private val mAppRepository: AppRepository): ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                TvShowsViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailMoviesViewModel::class.java) -> {
                DetailMoviesViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowsViewModel::class.java) -> {
                DetailTvShowsViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavouriteViewModel::class.java) -> {
                MovieFavouriteViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(TvShowFavouriteViewModel::class.java) -> {
                TvShowFavouriteViewModel(mAppRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }
    }
}