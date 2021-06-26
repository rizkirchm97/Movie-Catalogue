package com.rizki.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(
    var tvShowId: String,
    var title: String,
    var quote: String? = null,
    var genre: String,
    var totalTime: String,
    var overview: String,
    var network: String,
    var imagePath: String
): Parcelable
