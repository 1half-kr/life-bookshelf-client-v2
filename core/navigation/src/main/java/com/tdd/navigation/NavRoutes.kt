package com.tdd.navigation

sealed class NavRoutes(val route: String) {

    // OnBoarding Graph
    data object OnBoardingGraph: NavRoutes("onboarding_graph")
    data object UserNameScreen: NavRoutes("user_name")
}