package com.example.dsw51789.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ){
        Spacer(modifier = Modifier.height(62.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(129.dp),

        )
        Spacer(modifier = Modifier.height(21.dp))
        Text(
            text = "Sign in",
            color = Color(0xFF471AA0),
            textAlign = TextAlign.Left,
            fontSize = 36.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(46.dp))
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            label = { Text("Email or User Name")},
            leadingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Person, contentDescription = "")
                }
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            label = { Text("Password")},
            leadingIcon = {
                IconButton(onClick = {/*todo*/}) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                }
            },
            trailingIcon = {
                IconButton(onClick = {/*todo*/ }) {
                    Icon(imageVector = Icons.Outlined.Visibility, contentDescription = "")
                }
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
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
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB84E8)),
            onClick = { navController.navigate("Routes.homePage") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "Sign in")

        }
        Spacer(modifier = Modifier.height(200.dp))
        Text(
            text = buildAnnotatedString {
                append("Don't have account?")
                withStyle(style= SpanStyle(color = Color.Blue)) {
                    append("Sign up")
                }
            },
            textAlign = TextAlign.Right,
            fontSize =  20.sp ,
            modifier = Modifier
                .clickable {
                    navController.navigate("Routes.registerPage")
                }
        )
        Spacer(modifier = Modifier.height(40.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    val navController = rememberNavController()

    LoginPage(navController)
}