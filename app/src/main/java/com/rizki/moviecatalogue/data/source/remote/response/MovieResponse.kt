package com.rizki.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var moviesId: String,
    var title: String,
    var quotes: String,
    var genre: String,
    var totalTime: String,
    var overview: String,
    var releaseDate: String,
    var imagePath: String
): Parcelable
