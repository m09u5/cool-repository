package com.example.dsw51789.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dsw51789.utils.Routes
import com.example.dsw51789.viewmodel.AuthState
import com.example.dsw51789.viewmodel.AuthViewModel


@Composable
fun HomePage(navController: NavController, authViewModel: AuthViewModel){
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate(Routes.loginPage)
            else -> Unit
        }
    }
    TextButton(onClick = {
        authViewModel.signout()
    }) {
        Text(text = "sign out")
    }
}

