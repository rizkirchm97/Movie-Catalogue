package com.rizki.moviecatalogue.di

import android.content.Context
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.LocalDataSource
import com.rizki.moviecatalogue.data.source.local.room.AppDatabase
import com.rizki.moviecatalogue.data.source.remote.RemoteDataSource
import com.rizki.moviecatalogue.utils.AppExecutors
import com.rizki.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AppRepository {

        val database = AppDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        val localDataSource = LocalDataSource.getInstance(database.appDao())

        val appExecutors = AppExecutors()

        return AppRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}