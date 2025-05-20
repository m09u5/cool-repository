package com.example.dsw51789.view

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dsw51789.utils.Routes
import com.example.dsw51789.viewmodel.AuthState
import com.example.dsw51789.viewmodel.AuthViewModel

@Composable

fun RegisterPage(navController: NavController, authViewModel: AuthViewModel){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate(Routes.todoListPage)
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message,
                Toast.LENGTH_LONG).show()
            else -> Unit
        }
    }
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
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Full Name")},
            leadingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Person, contentDescription = "")
                }
            }

        )
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email")},
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Mail, contentDescription = "")
                }
            }

            )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password")},
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                }
            },
                    trailingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Visibility, contentDescription = "")
                }
            }

            )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Confirm Password")},
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                }
            },
            trailingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Visibility, contentDescription = "")
                }
            }

            )
        Button(onClick = {
            authViewModel.register(username.value, password.value)
        }, enabled = authState.value != AuthState.Loading) {
            Text(text = "sign up")
        }
        Text(
            text = "Already have account? Sign in",
            textAlign = TextAlign.Right,
            fontSize =  20.sp ,
            modifier = Modifier
                .clickable {
                    navController.navigate(Routes.loginPage)
                }
        )
    }
}
