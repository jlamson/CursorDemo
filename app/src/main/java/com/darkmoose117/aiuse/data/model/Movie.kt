package com.darkmoose117.aiuse.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>? = null
) : Parcelable

@Parcelize
data class ProductionCompany(
    val id: Int,
    val name: String,
    @SerializedName("logo_path")
    val logoPath: String?
) : Parcelable 