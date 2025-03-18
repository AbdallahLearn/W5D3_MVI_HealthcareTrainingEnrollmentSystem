package com.example.w5d3_classassignment.domain.usecase


import com.example.w5d3_classassignment.data.respository.TrainingRepository

class EnrollInProgramUseCase(private val repository: TrainingRepository) {
    operator fun invoke(programId: String): Boolean {
        return repository.enrollInProgram(programId)
    }
}