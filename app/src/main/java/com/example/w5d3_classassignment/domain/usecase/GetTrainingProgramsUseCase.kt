package com.example.w5d3_classassignment.domain.usecase

import com.example.w5d3_classassignment.data.model.TrainingProgram
import com.example.w5d3_classassignment.data.respository.TrainingRepository


class GetTrainingProgramsUseCase(private val repository: TrainingRepository) {
    operator fun invoke(): List<TrainingProgram> {
        return repository.getTrainingPrograms()
    }
}