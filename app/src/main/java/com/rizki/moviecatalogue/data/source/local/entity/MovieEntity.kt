package com.rizki.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviesentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "moviesId")
    var moviesId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "quotes")
    var quotes: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "totalTime")
    var totalTime: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "favourite")
    var favourite: Boolean = false,

    @ColumnInfo(name = "imagePath")
    var imagePath: String
)
