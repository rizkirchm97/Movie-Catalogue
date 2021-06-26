package com.rizki.moviecatalogue.ui.tvshows

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
class TvShowsViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Before
    fun setUp(){
        viewModel = TvShowsViewModel(appRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = DataDummy.generatedDummyTvShows()
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = dummyTvShows

        `when`(appRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowsEntities = viewModel.getTvShows().value
        verify(appRepository).getAllTvShows()
        assertNotNull(tvShowsEntities)
        assertEquals(10, tvShowsEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}