package ru.kaer.documentsapp.authorization.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kaer.documentsapp.authorization.viewmodel.SplashScreenViewModel
import ru.kaer.documentsapp.navigation.Screen

@Composable
fun AuthorizationFlow(
    authViewModel: SplashScreenViewModel = viewModel()
) {
    val navController = rememberNavController()
    val state = authViewModel.authState
    LaunchedEffect(key1 = state, block = {
        when(state.isAuthorizedInApp){
            true -> navController.navigate(Screen.InputCode.name){
                popUpTo(Screen.SplashScreen.name) {
                    inclusive = true
                }
                launchSingleTop = true
                restoreState = true
            }
            false -> navController.navigate(Screen.Registration.name){
                popUpTo(Screen.SplashScreen.name) {
                    inclusive = true
                }
                launchSingleTop = true
                restoreState = true
            }
            else -> {}
        }
    })

    NavHost(navController = navController, startDestination = Screen.SplashScreen.name){
        composable(Screen.SplashScreen.name){
            SplashScreen()
        }

        composable(Screen.InputCode.name){
            InputCodeScreen{
                navController.navigate(Screen.Zone.name){
                    popUpTo(Screen.InputCode.name) {
                        saveState = true
                        inclusive = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }

        composable(Screen.Registration.name){
            RegistrationScreen{
                navController.navigate(Screen.CreateInputCode.name){
                    popUpTo(Screen.Registration.name) {
                        saveState = true
                        inclusive = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }

        composable(Screen.CreateInputCode.name){
            CreateInputCodeScreen(){
                navController.navigate(Screen.Zone.name){
                    popUpTo(Screen.CreateInputCode.name) {
                        saveState = true
                        inclusive = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }

        composable(Screen.Zone.name){
            Text("qweqwjeljqwlej")
        }
    }
}