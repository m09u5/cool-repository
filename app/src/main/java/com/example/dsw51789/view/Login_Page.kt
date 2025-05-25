package com.example.dsw51789.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dsw51789.R
import com.example.dsw51789.utils.Routes
import com.example.dsw51789.viewmodel.AuthState
import com.example.dsw51789.viewmodel.AuthViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController, authViewModel: AuthViewModel){
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
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
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
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
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(46.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF9747FF),
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(horizontal = 12.dp, vertical = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = null,
                    tint = Color(0xFF471AA0),
                    modifier = Modifier.size(23.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                BasicTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Gray,
                        fontSize = 16.sp,
                    ),
                    decorationBox = { innerTextField ->
                        if (email.value.isEmpty()) {
                            Text(
                                text = "Email or User Name",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        var passwordVisible by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF9747FF),
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = null,
                    tint = Color(0xFF471AA0),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                BasicTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    modifier = Modifier.weight(1f),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                    decorationBox = { innerTextField ->
                        if (password.value.isEmpty()) {
                            Text("Password", color = Color.Gray, fontSize = 16.sp)
                        }
                        innerTextField()
                    }
                )

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                        contentDescription = null
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Forget password?",
            color = Color.Blue ,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Routes.registerPage)
                }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB84E8)),
            onClick = { authViewModel.login(email.value, password.value) },
            enabled = authState.value != AuthState.Loading,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)

        ) {
            Text(
                text = "Sign in",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,)
        }
        Spacer(modifier = Modifier.height(200.dp))
        Text(color = Color(0xFF471AA0),
            text = buildAnnotatedString {
                append("Don't have account ? ")
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.Bold)) {
                    append("Sign up")
                }
            },
            textAlign = TextAlign.Right,
            fontSize =  18.sp ,
            modifier = Modifier
                .clickable {
                    navController.navigate(Routes.registerPage)
                }
        )
        Spacer(modifier = Modifier.height(40.dp))

    }
}