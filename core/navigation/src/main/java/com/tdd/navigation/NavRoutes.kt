package com.tdd.navigation

sealed class NavRoutes(val route: String) {

    // OnBoarding Graph
    data object OnBoardingGraph: NavRoutes("onboarding_graph")
    data object UserAgeScreen: NavRoutes("user_age")
    data object UserGenderScreen: NavRoutes("user_gender")
    data object ScholarShipScreen: NavRoutes("scholarship")
    data object MarriageScreen: NavRoutes("marriage")
    data object OnBoardingScreen: NavRoutes("onboarding")

    // InterView Graph
    data object InterViewGraph: NavRoutes("interview_graph")
    data object StartInterViewScreen: NavRoutes("start_interview")
    data object InterviewScreen: NavRoutes("interview")
}