package com.example.w5d3_classassignment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.w5d3_classassignment.presentation.enrollment.EnrollmentScreen
import com.example.w5d3_classassignment.presentation.enrollment.EnrollmentViewModel
import com.example.w5d3_classassignment.presentation.traininglist.TrainingListScreen
import com.example.w5d3_classassignment.presentation.traininglist.TrainingListViewModel


@Composable
fun NavGraph(
    trainingListViewModel: TrainingListViewModel,
    enrollmentViewModel: EnrollmentViewModel,
    modifier: Modifier = Modifier // Add modifier parameter
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "trainingList",
        modifier = modifier // Pass the modifier to NavHost
    ) {
        composable("trainingList") {
            TrainingListScreen(viewModel = trainingListViewModel) {
                navController.navigate("signup")
            }
        }
        composable("signup") {
            EnrollmentScreen(
                viewModel = enrollmentViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}