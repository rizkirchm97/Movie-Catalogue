package com.rizki.moviecatalogue.ui.detail.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {

    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovies.moviesId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>


    @Before
    fun setUp(){
        viewModel = DetailMoviesViewModel(appRepository)
        viewModel.setSelectedMovies(movieId)
    }

    @Test
    fun getMovies() {
        val movies = MutableLiveData<MovieEntity>()
        movies.value = dummyMovies

        `when`(appRepository.getMovieById(movieId)).thenReturn(movies)
        val movieEntity = viewModel.getMovies().value as MovieEntity
        assertNotNull(movieEntity)
        assertEquals(dummyMovies.moviesId, movieEntity.moviesId)
        assertEquals(dummyMovies.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovies.genre, movieEntity.genre)
        assertEquals(dummyMovies.overview, movieEntity.overview)
        assertEquals(dummyMovies.quotes, movieEntity.quotes)
        assertEquals(dummyMovies.title, movieEntity.title)
        assertEquals(dummyMovies.totalTime, movieEntity.totalTime)
        assertEquals(dummyMovies.imagePath, movieEntity.imagePath)

        viewModel.getMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }
}