package com.rizki.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.rizki.moviecatalogue.data.NetworkBoundResource
import com.rizki.moviecatalogue.data.source.local.LocalDataSource
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.data.source.remote.ApiResponse
import com.rizki.moviecatalogue.data.source.remote.RemoteDataSource
import com.rizki.moviecatalogue.data.source.remote.response.MovieResponse
import com.rizki.moviecatalogue.data.source.remote.response.TvShowResponse
import com.rizki.moviecatalogue.utils.AppExecutors
import com.rizki.moviecatalogue.vo.Resource

class AppRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ): AppDataSource{
    companion object {
        @Volatile
        private var instance: AppRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): AppRepository =
            instance ?: synchronized(this) {
                instance ?: AppRepository(remoteDataSource, localDataSource, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getAllLocalMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.moviesId,
                        response.title,
                        response.quotes,
                        response.genre,
                        response.totalTime,
                        response.overview,
                        response.releaseDate,
                        false,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieById(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors) {
            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null || data.equals("")


            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieById(movieId)

            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getMovieById(movieId)

            override fun saveCallResult(data: MovieResponse) {
                val movie = MovieEntity(
                    data.moviesId,
                    data.title,
                    data.quotes,
                    data.genre,
                    data.totalTime,
                    data.overview,
                    data.releaseDate,
                    false,
                    data.imagePath
                )
                localDataSource.updateMovie(movie)
            }

        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                localDataSource.getAllLocalTvShows()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()

                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.tvShowId,
                        response.title,
                        response.quote,
                        response.genre,
                        response.totalTime,
                        response.overview,
                        response.network,
                        false,
                        response.imagePath)

                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getTvShowById(tvShowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowResponse>(appExecutors) {
            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null || data.equals("")

            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowById(tvShowId)

            override fun createCall(): LiveData<ApiResponse<TvShowResponse>> =
                remoteDataSource.getTvShowById(tvShowId)

            override fun saveCallResult(data: TvShowResponse) {
                val tvShow = TvShowEntity(
                    data.tvShowId,
                    data.title,
                    data.quote,
                    data.genre,
                    data.totalTime,
                    data.overview,
                    data.network,
                    false,
                    data.imagePath
                )
                localDataSource.updateTvShow(tvShow)
            }

        }.asLiveData()
    }

    override fun getMovieFavourite(): LiveData<List<MovieEntity>> =
        localDataSource.getFavouriteMovie()

    override fun getTvShowFavourite(): LiveData<List<TvShowEntity>> =
        localDataSource.getFavouriteTvShow()

    override fun setMovieFavourite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavourite(movie, state) }

    override fun setTvShowFavourite(tvSHow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavourite(tvSHow, state) }
}