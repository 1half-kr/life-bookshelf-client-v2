package com.tdd.feature

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tdd.design_system.White4
import com.tdd.domain.entity.request.CreateUserModel
import com.tdd.feature.component.BottomNavBar
import com.tdd.navigation.NavRoutes
import com.tdd.navigation.interviewChapterNavGraph
import com.tdd.navigation.interviewNavGraph
import com.tdd.navigation.onBoardingNavGraph
import com.tdd.ui.common.dialog.InterviewTypeDialog
import com.tdd.ui.util.DismissKeyboardOnClick
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    val viewModel: MainViewModel = hiltViewModel()
    val uiState: MainPageState by viewModel.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val isShowDialog = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    val settingUserModel: (CreateUserModel) -> Unit = {
        scope.launch {
            viewModel.userModel.emit(it)
        }
    }
    val showDialog: () -> Unit = {
        isShowDialog.value = true
    }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow
            .distinctUntilChanged()
            .collect { backStackEntry ->
                viewModel.setBottomNavType(backStackEntry.destination.route)
            }
    }

    DismissKeyboardOnClick {
        if (isShowDialog.value) {
            InterviewTypeDialog(
                onSelectType = { type ->
                    viewModel.setInterviewType(type)
                    isShowDialog.value = false
                    navController.navigate(NavRoutes.InterviewScreen.route)
                },
                onDismiss = { isShowDialog.value = false },
            )
        }

        Scaffold(
            bottomBar = {
                AnimatedVisibility(
                    visible = uiState.bottomNavType != BottomNavType.DEFAULT,
                    modifier = Modifier.background(White4),
                    enter = fadeIn() + slideIn { IntOffset(0, 0) },
                    exit = fadeOut() + slideOut { IntOffset(0, 0) }
                ) {
                    BottomNavBar(
                        interactionSource = interactionSource,
                        modifier = Modifier.navigationBarsPadding(),
                        type = uiState.bottomNavType,
                        onClick = { route: String ->
                            if (navController.currentDestination?.route != route) {
                                navController.navigate(route) {
                                    popUpTo(navController.currentDestination?.route!!) {
                                        inclusive = true
                                    }
                                    launchSingleTop = true
                                }
                            }
                        }
                    )
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NavRoutes.OnBoardingGraph.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                onBoardingNavGraph(
                    navController = navController,
                    setUserModel = settingUserModel,
                    userModel = viewModel.userModel
                )
                interviewNavGraph(
                    navController = navController,
                    showDialog = showDialog
                )
                interviewChapterNavGraph(
                    navController = navController
                )
            }
        }
    }
}