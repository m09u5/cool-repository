package com.example.dsw51789

import TodoListPage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dsw51789.utils.Routes
import com.example.dsw51789.view.LoginPage
import com.example.dsw51789.view.RegisterPage
import com.example.dsw51789.viewmodel.AuthState
import com.example.dsw51789.viewmodel.AuthViewModel
import com.example.dsw51789.viewmodel.ContactViewModel
import androidx.compose.runtime.getValue



@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val authState by authViewModel.authState.observeAsState()

    val startDestination = when (authState) {
        is AuthState.Authenticated -> Routes.todoListPage
        else -> Routes.loginPage
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.loginPage) {
            LoginPage(navController, authViewModel)
        }
        composable(Routes.registerPage) {
            RegisterPage(navController, authViewModel)
        }
        composable(Routes.todoListPage) {
            val contactViewModel: ContactViewModel = viewModel()
            TodoListPage(contactViewModel, authViewModel, navController)
        }
    }
}
