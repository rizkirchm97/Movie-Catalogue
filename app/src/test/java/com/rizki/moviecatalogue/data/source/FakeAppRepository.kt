package com.rizki.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.data.source.remote.RemoteDataSource
import com.rizki.moviecatalogue.data.source.remote.response.MovieResponse
import com.rizki.moviecatalogue.data.source.remote.response.TvShowResponse

class FakeAppRepository (private val remoteDataSource: RemoteDataSource): AppDataSource{

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(
                        response.moviesId,
                        response.title,
                        response.quotes,
                        response.genre,
                        response.totalTime,
                        response.overview,
                        response.releaseDate,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)
            }
        })

        return  movieResult
    }

    override fun getMovieById(movieId: String): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in movieResponse) {
                    if (response.moviesId == movieId) {
                        movie = MovieEntity(
                            response.moviesId,
                            response.title,
                            response.quotes,
                            response.genre,
                            response.totalTime,
                            response.overview,
                            response.releaseDate,
                            response.imagePath
                        )
                    }
                }
                movieResult.postValue(movie)
            }
        })

        return movieResult
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowResult = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
                    val tvShow = TvShowEntity( response.tvShowId,
                        response.title,
                        response.quote,
                        response.genre,
                        response.totalTime,
                        response.overview,
                        response.network,
                        response.imagePath
                    )
                    tvShowList.add(tvShow)
                }
                tvShowResult.postValue(tvShowList)
            }
        })

        return tvShowResult
    }

    override fun getTvShowById(tvShowId: String): LiveData<TvShowEntity> {
        val tvShowResult = MutableLiveData<TvShowEntity>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                for (response in tvShowResponse) {
                    if (response.tvShowId == tvShowId) {
                        tvShow = TvShowEntity(
                            response.tvShowId,
                            response.title,
                            response.quote,
                            response.genre,
                            response.totalTime,
                            response.overview,
                            response.network,
                            response.imagePath
                        )
                    }
                }

                tvShowResult.postValue(tvShow)
            }
        })

        return tvShowResult
    }
}