package com.tdd.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tdd.onboarding.userage.UserAgeScreen

fun NavGraphBuilder.onBoardingNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = NavRoutes.UserAgeScreen.route,
        route = NavRoutes.OnBoardingGraph.route
    ) {
        composable(NavRoutes.UserAgeScreen.route) {
            UserAgeScreen()
        }
    }
}