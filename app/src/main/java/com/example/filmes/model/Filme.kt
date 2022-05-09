package com.example.filmes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filme(
    val id: Int?,
    val adult: Boolean?,
    val title: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("popularity")
    val popularity: Double?,
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("media_type")
    val mediaType: String?
) : Parcelable
