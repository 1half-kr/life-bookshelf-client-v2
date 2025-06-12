package com.tdd.feature

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tdd.domain.entity.request.CreateUserModel
import com.tdd.navigation.NavRoutes
import com.tdd.navigation.interviewNavGraph
import com.tdd.navigation.onBoardingNavGraph
import com.tdd.ui.common.dialog.InterviewTypeDialog
import com.tdd.ui.common.type.InterviewType
import com.tdd.ui.util.DismissKeyboardOnClick
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    val viewModel: MainViewModel = hiltViewModel()
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val isShowDialog = remember { mutableStateOf(false) }

    val settingUserModel: (CreateUserModel) -> Unit = {
        scope.launch {
            viewModel.userModel.emit(it)
        }
    }
    val showDialog: () -> Unit = {
        isShowDialog.value = true
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
            bottomBar = { BottomNavBar() }
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
            }
        }
    }
}

@Composable
fun BottomNavBar() {
}