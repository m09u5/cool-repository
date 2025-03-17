package com.example.dsw51789.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dsw51789.R

@Composable
fun LoginPage(navController: NavController){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Sign in",
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email or User Name")},
            leadingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Person, contentDescription = "")
                }
            }


        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password")},
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
        Text(
            text = "Forget password?",
            color = Color.Blue ,
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("Routes.registerPage")
                }
        )
        Button(
            onClick = { /*todo*/ },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign in")

        }

        Text(
            text = "Or sign in with"
        )
        Row(
            modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = { /*todo*/ },
                modifier = Modifier
                    .size(60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Button(
                onClick = { /*todo*/ },
                modifier = Modifier
                    .size(60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Button(
                onClick = { /*todo*/ },
                modifier = Modifier
                    .size(60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.twitter),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Button(
                onClick = { /*todo*/ },
                modifier = Modifier
                    .size(60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }
        }
        Text(
            text = "Don't have account? Sign up",
            textAlign = TextAlign.Right,
            fontSize =  20.sp ,
            modifier = Modifier
                .clickable {
                    navController.navigate("Routes.registerPage")
                }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    val navController = rememberNavController()

    LoginPage(navController)
}