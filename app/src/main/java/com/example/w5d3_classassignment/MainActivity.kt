package com.example.w5d3_classassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.w5d3_classassignment.data.respository.TrainingRepository
import com.example.w5d3_classassignment.domain.usecase.EnrollInProgramUseCase
import com.example.w5d3_classassignment.domain.usecase.GetTrainingProgramsUseCase
import com.example.w5d3_classassignment.presentation.enrollment.EnrollmentViewModel
import com.example.w5d3_classassignment.presentation.navigation.NavGraph
import com.example.w5d3_classassignment.presentation.traininglist.TrainingListViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Initialize dependencies
            val trainingRepository = TrainingRepository()
            val getTrainingProgramsUseCase = GetTrainingProgramsUseCase(trainingRepository)
            val enrollInProgramUseCase = EnrollInProgramUseCase(trainingRepository)

            // Initialize ViewModels
            val trainingListViewModel = TrainingListViewModel(getTrainingProgramsUseCase)
            val enrollmentViewModel = EnrollmentViewModel(enrollInProgramUseCase)


            AppTheme {
                Scaffold(
                    topBar = { TopAppBar() },
                    bottomBar = { BottomNavigationBar() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // Pass the padding to the NavGraph
                    NavGraph(
                        trainingListViewModel = trainingListViewModel,
                        enrollmentViewModel = enrollmentViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//top bar component
@Composable
fun TopAppBar() {
    Column (
        modifier = Modifier.fillMaxWidth()
            .background(Color(0xFFE3DFDF))

    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier.size(50.dp)

                )
            }



            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ){
            Text(
                text = "Programs and Activities",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
                textAlign = TextAlign.Start
            )

            TextField(
                value = "",
                onValueChange = { },
                placeholder = { Text("Search...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            )
        }

    }
}


// BottomBar Component
@Composable
fun BottomNavigationBar() {
    val items = listOf("Home", "Profile", "Settings")
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    when (item) {
                        "Home" -> Icon(Icons.Default.Home, contentDescription = item , modifier = Modifier.size(35.dp))
                        "Profile" -> Icon(Icons.Default.Person, contentDescription = item ,modifier = Modifier.size(35.dp))
                        "Settings" -> Icon(Icons.Default.Settings, contentDescription = item, modifier = Modifier.size(35.dp))
                        else -> Icon(Icons.Default.Favorite, contentDescription = item)
                    }
                },
                label = { Text(text = item) },
                selected = item == "Home",
                onClick = {  }
            )
        }
    }
}

// App Theme
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        content = content
    )
}
