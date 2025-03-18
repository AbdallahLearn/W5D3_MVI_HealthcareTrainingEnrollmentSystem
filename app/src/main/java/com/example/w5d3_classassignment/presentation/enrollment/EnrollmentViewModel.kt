package com.example.w5d3_classassignment.presentation.enrollment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5d3_classassignment.domain.usecase.EnrollInProgramUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class EnrollmentViewModel(
    private val enrollInProgramUseCase: EnrollInProgramUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<EnrollmentState>(EnrollmentState.Idle)
    val state: StateFlow<EnrollmentState> = _state

    fun enroll(name: String, email: String, password: String) {
        viewModelScope.launch {
            _state.value = EnrollmentState.Loading
            try {
                // Simulate signup process
                val success = enrollInProgramUseCase(email) // Use email as programId for now
                if (success) {
                    _state.value = EnrollmentState.Success("Signup successful!")
                } else {
                    _state.value = EnrollmentState.Error("Signup failed")
                }
            } catch (e: Exception) {
                _state.value = EnrollmentState.Error("An error occurred")
            }
        }
    }
}