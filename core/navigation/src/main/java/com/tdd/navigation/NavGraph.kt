package com.tdd.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tdd.onboarding.username.UserNameScreen

fun NavGraphBuilder.onBoardingNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = NavRoutes.UserNameScreen.route,
        route = NavRoutes.OnBoardingGraph.route
    ) {
        composable(NavRoutes.UserNameScreen.route) {
            UserNameScreen()
        }
    }
}