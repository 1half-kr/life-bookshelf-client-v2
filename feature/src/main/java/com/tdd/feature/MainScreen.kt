package com.tdd.feature

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tdd.domain.entity.request.CreateUserModel
import com.tdd.navigation.NavRoutes
import com.tdd.navigation.onBoardingNavGraph
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    val viewModel: MainViewModel = hiltViewModel()
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    val settingUserModel: (CreateUserModel) -> Unit = {
        scope.launch {
            viewModel.userModel.emit(it)
        }
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
        }
    }
}

@Composable
fun BottomNavBar() {
}