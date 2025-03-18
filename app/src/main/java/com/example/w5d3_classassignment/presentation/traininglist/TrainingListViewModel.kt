package com.example.w5d3_classassignment.presentation.traininglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5d3_classassignment.domain.usecase.GetTrainingProgramsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class TrainingListViewModel(
    private val getTrainingProgramsUseCase: GetTrainingProgramsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<TrainingListState>(TrainingListState.Loading)
    val state: StateFlow<TrainingListState> = _state

    init {
        loadTrainingPrograms()
    }

    private fun loadTrainingPrograms() {
        viewModelScope.launch {
            _state.value = TrainingListState.Loading
            try {
                val programs = getTrainingProgramsUseCase()
                _state.value = TrainingListState.Success(programs)
            } catch (e: Exception) {
                _state.value = TrainingListState.Error("Failed to load programs")
            }
        }
    }
}