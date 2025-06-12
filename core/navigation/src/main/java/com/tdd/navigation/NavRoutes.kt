package com.tdd.navigation

sealed class NavRoutes(val route: String) {

    // OnBoarding Graph
    data object OnBoardingGraph: NavRoutes("onboarding_graph")
    data object UserAgeScreen: NavRoutes("user_age")
    data object UserGenderScreen: NavRoutes("user_gender")
    data object ScholarShipScreen: NavRoutes("scholarship")
}