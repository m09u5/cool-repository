package com.example.dsw51789.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun RegisterPage(navController: NavController){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "sign up",
            modifier = Modifier
                .fillMaxWidth()

        )
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Full Name")}

        )
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email")},

            )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password")},

            )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Repassword")},

            )
        Text(
            text = "already have account? sign in",
            textAlign = TextAlign.Right,
            fontSize =  20.sp ,
            modifier = Modifier
                .clickable {
                    navController.navigate("Routes.loginPage")
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPagePreview(){
    val navController = rememberNavController()
    RegisterPage(navController)
}