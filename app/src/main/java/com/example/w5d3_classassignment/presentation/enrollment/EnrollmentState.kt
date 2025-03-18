package com.example.w5d3_classassignment.presentation.enrollment


sealed class EnrollmentState {
    object Idle : EnrollmentState()
    object Loading : EnrollmentState()
    data class Success(val message: String) : EnrollmentState()
    data class Error(val message: String) : EnrollmentState()
}