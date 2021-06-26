package com.rizki.moviecatalogue.ui.detail.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
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
class DetailTvShowsViewModelTest {
    private lateinit var viewModel: DetailTvShowsViewModel
    private val dummyTvShows = DataDummy.generatedDummyTvShows()[0]
    private val tvShowId = dummyTvShows.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowsViewModel(appRepository)
        viewModel.setSelectedTvShows(tvShowId)
    }

    @Test
    fun getTvShows() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShows

        `when`(appRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
        val tvShowsEntity = viewModel.getTvShows().value as TvShowEntity
        assertNotNull(tvShowsEntity)
        assertEquals(dummyTvShows.tvShowId, tvShowsEntity.tvShowId)
        assertEquals(dummyTvShows.genre, tvShowsEntity.genre)
        assertEquals(dummyTvShows.overview, tvShowsEntity.overview)
        assertEquals(dummyTvShows.network, tvShowsEntity.network)
        assertEquals(dummyTvShows.quote, tvShowsEntity.quote)
        assertEquals(dummyTvShows.title, tvShowsEntity.title)
        assertEquals(dummyTvShows.totalTime, tvShowsEntity.totalTime)
        assertEquals(dummyTvShows.imagePath, tvShowsEntity.imagePath)

        viewModel.getTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows)
    }
}