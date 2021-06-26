package com.rizki.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.vo.Resource

class MoviesViewModel(private val appRepository: AppRepository): ViewModel() {

    fun getMovies(): LiveData<Resource<List<MovieEntity>>> = appRepository.getAllMovies()
}