package com.example.dsw51789.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomePage(navController: NavController){
    Text(
        text="homepage"
    )
}
@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    val navController = rememberNavController()

    HomePage(navController)
}
