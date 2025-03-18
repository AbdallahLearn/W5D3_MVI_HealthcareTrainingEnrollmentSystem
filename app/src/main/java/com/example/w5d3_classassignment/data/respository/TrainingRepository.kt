package com.example.w5d3_classassignment.data.respository

import com.example.w5d3_classassignment.data.model.TrainingProgram

class TrainingRepository {

    // Simulate fetching training programs from a remote or local source
    fun getTrainingPrograms(): List<TrainingProgram> {
        return listOf(
            TrainingProgram(
                id = "1",
                title = "CPR Certification Course",
                description = "Learn CPR techniques",
                date = "2023-12-01",
                image = "https://i.pinimg.com/736x/f3/aa/8f/f3aa8f25c8d954d0f15b0c2d5fae6a26.jpg"
            ),
            TrainingProgram(
                id = "2",
                title = "First Aid Essentials",
                description = "Basic first aid skills",
                date = "2023-12-15",
                image = "https://i.pinimg.com/736x/f7/9d/ea/f79deaa9053b59cfec4d6b0ad54f59ce.jpg"
            ),
            TrainingProgram(
                id = "3",
                title = "Advanced Cardiac Life ",
                description = "ALS for healthcare ",
                date = "2024-01-10",
                image = "https://i.pinimg.com/736x/ed/9b/97/ed9b971903440df8b608a705cf5e4ecf.jpg"
            )
        )
    }

    // Simulate enrolling in a training program
    fun enrollInProgram(programId: String): Boolean {
        // Simulate network call or database operation
        return true
    }
}