package com.example.dsw51789

import TodoListPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dsw51789.ui.theme.Dsw51789Theme
import com.example.dsw51789.ui.theme.TodoAppTheme
import com.example.dsw51789.view.HomePage
import com.example.dsw51789.view.LoginPage
import com.example.dsw51789.view.RegisterPage
import com.example.dsw51789.viewmodel.AuthViewModel
import com.example.dsw51789.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel: AuthViewModel by viewModels()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                MyAppNavigation(
                    modifier = Modifier.padding(innerPadding),
                    authViewModel = authViewModel)
            }
        }
    }
}
