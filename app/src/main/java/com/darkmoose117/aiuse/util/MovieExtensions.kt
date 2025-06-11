package com.darkmoose117.aiuse.util

import com.darkmoose117.aiuse.data.api.TMDBApi
import com.darkmoose117.aiuse.data.model.Movie

fun Movie.getYear(): String {
    return if (releaseDate.isNotBlank()) {
        releaseDate.substring(0, 4)
    } else {
        "Unknown"
    }
}

fun Movie.getPosterUrl(): String? {
    return posterPath?.let { path ->
        TMDBApi.IMAGE_BASE_URL + path
    }
} 