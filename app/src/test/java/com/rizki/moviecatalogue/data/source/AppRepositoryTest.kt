package com.rizki.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.rizki.moviecatalogue.data.source.remote.RemoteDataSource
import com.rizki.moviecatalogue.utils.DataDummy
import com.rizki.moviecatalogue.utils.LiveDataTestUtil
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class AppRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val appRepository = FakeAppRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val tvShowResponse = DataDummy.generatedRemoteDummyTvShows()
    private val movieId = movieResponse[0].moviesId
    private val tvShowId = tvShowResponse[0].tvShowId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getMovies(any())
        val moviesEntities = LiveDataTestUtil.getValue(appRepository.getAllMovies())
        verify(remote).getMovies(any())
        assertNotNull(moviesEntities)
        assertEquals(movieResponse.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getMovieById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getMovies(any())

        val moviesEntities = LiveDataTestUtil.getValue(appRepository.getMovieById(movieId))
        verify(remote).getMovies(any())

        assertNotNull(moviesEntities)
        assertNotNull(moviesEntities.title)
        assertEquals(movieResponse[0].title, moviesEntities.title)
        assertNotNull(moviesEntities.quotes)
        assertEquals(movieResponse[0].quotes, moviesEntities.quotes)
        assertNotNull(moviesEntities.genre)
        assertEquals(movieResponse[0].genre, moviesEntities.genre)
        assertNotNull(moviesEntities.totalTime)
        assertEquals(movieResponse[0].totalTime, moviesEntities.totalTime)
        assertNotNull(moviesEntities.overview)
        assertEquals(movieResponse[0].overview, moviesEntities.overview)
        assertNotNull(moviesEntities.releaseDate)
        assertEquals(movieResponse[0].releaseDate, moviesEntities.releaseDate)
        assertNotNull(moviesEntities.imagePath)
    }

    @Test
    fun getAllTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowsReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShows(any())
        val tvShowEntities = LiveDataTestUtil.getValue(appRepository.getAllTvShows())
        verify(remote).getTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTvShowById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowsReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShows(any())
        val tvShowEntities = LiveDataTestUtil.getValue(appRepository.getTvShowById(tvShowId))
        verify(remote).getTvShows(any())
        assertNotNull(tvShowEntities)
        assertNotNull(tvShowEntities.title)
        assertEquals(tvShowResponse[0].title, tvShowEntities.title)
        assertNotNull(tvShowEntities.quote)
        assertEquals(tvShowResponse[0].quote, tvShowEntities.quote)
        assertNotNull(tvShowEntities.genre)
        assertEquals(tvShowResponse[0].genre, tvShowEntities.genre)
        assertNotNull(tvShowEntities.totalTime)
        assertEquals(tvShowResponse[0].totalTime, tvShowEntities.totalTime)
        assertNotNull(tvShowEntities.network)
        assertEquals(tvShowResponse[0].network, tvShowEntities.network)
        assertNotNull(tvShowEntities.overview)
        assertEquals(tvShowResponse[0].overview, tvShowEntities.overview)
        assertNotNull(tvShowEntities.imagePath)
    }

}