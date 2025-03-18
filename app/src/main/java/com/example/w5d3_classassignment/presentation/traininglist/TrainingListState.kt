package com.example.w5d3_classassignment.presentation.traininglist

import com.example.w5d3_classassignment.data.model.TrainingProgram

sealed class TrainingListState {
    object Loading : TrainingListState()
    data class Success(val programs: List<TrainingProgram>) : TrainingListState()
    data class Error(val message: String) : TrainingListState()
}