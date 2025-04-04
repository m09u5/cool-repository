package com.example.dsw51789.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomePage(navController: NavController){
    Text(
        modifier = Modifier
            .padding(50.dp)
            .clickable{
                navController.navigate("Routes.loginPage")
            },
        text="homepage"
    )
}
@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    val navController = rememberNavController()

    HomePage(navController)
}
