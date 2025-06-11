package com.darkmoose117.aiuse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.darkmoose117.aiuse.data.model.Movie
import com.darkmoose117.aiuse.presentation.moviedetail.MovieDetailScreen
import com.darkmoose117.aiuse.presentation.movielist.MovieListScreen

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
    object MovieDetail : Screen("movie_detail")
}

@Composable
fun MovieNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MovieList.route
    ) {
        composable(Screen.MovieList.route) {
            MovieListScreen(
                onMovieClick = { movie ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("movie", movie)
                    navController.navigate(Screen.MovieDetail.route)
                }
            )
        }
        
        composable(Screen.MovieDetail.route) {
            val movie = navController.previousBackStackEntry?.savedStateHandle?.get<Movie>("movie")
            movie?.let {
                MovieDetailScreen(
                    movie = it,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
} 