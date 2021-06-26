package com.rizki.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowsentities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "quote")
    var quote: String? = null,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "totalTime")
    var totalTime: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "network")
    var network: String,

    @ColumnInfo(name = "favourite")
    var favourite: Boolean = false,

    @ColumnInfo(name = "imagePath")
    var imagePath: String
)
