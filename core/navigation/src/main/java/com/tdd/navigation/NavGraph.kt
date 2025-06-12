package com.tdd.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tdd.domain.entity.request.CreateUserModel
import com.tdd.interview.InterviewScreen
import com.tdd.interview.start.InterviewStartScreen
import com.tdd.onboarding.OnBoardingScreen
import com.tdd.onboarding.education.ScholarShipScreen
import com.tdd.onboarding.gender.UserGenderScreen
import com.tdd.onboarding.marriage.MarriageScreen
import com.tdd.onboarding.userage.UserAgeScreen
import kotlinx.coroutines.flow.SharedFlow

fun NavGraphBuilder.onBoardingNavGraph(
    navController: NavController,
    setUserModel: (CreateUserModel) -> Unit,
    userModel: SharedFlow<CreateUserModel>,
) {
    navigation(
        startDestination = NavRoutes.UserAgeScreen.route,
        route = NavRoutes.OnBoardingGraph.route
    ) {
        composable(NavRoutes.UserAgeScreen.route) {
            UserAgeScreen(
                goToUserGenderPage = {
                    setUserModel(it)
                    navController.navigate(NavRoutes.UserGenderScreen.route)
                }
            )
        }

        composable(NavRoutes.UserGenderScreen.route) {
            UserGenderScreen(
                userModel = userModel,
                goToEducationPage = {
                    setUserModel(it)
                    navController.navigate(NavRoutes.ScholarShipScreen.route)
                }
            )
        }

        composable(NavRoutes.ScholarShipScreen.route) {
            ScholarShipScreen(
                userModel = userModel,
                goToSelectMarryPage = {
                    setUserModel(it)
                    navController.navigate(NavRoutes.MarriageScreen.route)
                }
            )
        }

        composable(NavRoutes.MarriageScreen.route) {
            MarriageScreen(
                userModel = userModel,
                goToCreateChapterPage = {
                    setUserModel(it)
                    navController.navigate(NavRoutes.OnBoardingScreen.route)
                }
            )
        }

        composable(NavRoutes.OnBoardingScreen.route) {
            OnBoardingScreen(
                userModel = userModel,
                goToInterviewPage = {
                    navController.navigate(NavRoutes.StartInterViewScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}

fun NavGraphBuilder.interviewNavGraph(
    navController: NavController,
    showDialog: () -> Unit
) {
    navigation(
        startDestination = NavRoutes.StartInterViewScreen.route,
        route = NavRoutes.InterViewGraph.route
    ) {
        composable(NavRoutes.StartInterViewScreen.route) {
            InterviewStartScreen(
                showInterviewDialog = showDialog,
                goHomePage = {
                    //
                }
            )
        }

        composable(NavRoutes.InterviewScreen.route) {
            InterviewScreen()
        }
    }
}