package com.example.dsw51789

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dsw51789.view.HomePage
import com.example.dsw51789.view.LoginPage
import com.example.dsw51789.view.RegisterPage
import com.example.dsw51789.viewmodel.AuthViewModel

@Composable
//        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    //            val todoViewModel = ViewModelProvider(owner = this)[TodoViewModel::class.java]
    NavHost(navController = navController, startDestination = "Routes.loginPage", builder = {
        composable("Routes.loginPage"){
            LoginPage(navController, authViewModel)
        }
        composable("Routes.registerPage"){
            RegisterPage(navController, authViewModel)
        }
        composable("Routes.homePage") {
            HomePage(navController, authViewModel)
        }
//                    composable("Routes.todoListPage") {
//                        TodoViewModel(navController, authViewModel)
//                    }
    })

}