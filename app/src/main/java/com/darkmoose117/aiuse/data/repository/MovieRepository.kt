package com.darkmoose117.aiuse.data.repository

import com.darkmoose117.aiuse.data.api.TMDBApi
import com.darkmoose117.aiuse.data.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val message: String) : Resource<T>()
    data class Loading<T>(val data: T? = null) : Resource<T>()
}

@Singleton
class MovieRepository @Inject constructor(
    private val api: TMDBApi
) {
    
    fun getPopularMovies(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getPopularMovies(TMDBApi.API_KEY)
            if (response.isSuccessful) {
                response.body()?.let { movieResponse ->
                    emit(Resource.Success(movieResponse.results))
                } ?: emit(Resource.Error("Response body is null"))
            } else {
                emit(Resource.Error("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
    
    fun searchMovies(query: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.searchMovies(TMDBApi.API_KEY, query)
            if (response.isSuccessful) {
                response.body()?.let { movieResponse ->
                    emit(Resource.Success(movieResponse.results))
                } ?: emit(Resource.Error("Response body is null"))
            } else {
                emit(Resource.Error("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
    
    fun getMovieDetails(movieId: Int): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getMovieDetails(movieId, TMDBApi.API_KEY)
            if (response.isSuccessful) {
                response.body()?.let { movie ->
                    emit(Resource.Success(movie))
                } ?: emit(Resource.Error("Response body is null"))
            } else {
                emit(Resource.Error("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
} 