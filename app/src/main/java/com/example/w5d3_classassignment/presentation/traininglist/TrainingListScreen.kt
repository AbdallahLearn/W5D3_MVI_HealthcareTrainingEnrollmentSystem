package com.example.w5d3_classassignment.presentation.traininglist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.w5d3_classassignment.data.model.TrainingProgram


@Composable
fun TrainingListScreen(
    viewModel: TrainingListViewModel,
    onProgramSelected: (String) -> Unit
) {
    val state by viewModel.state.collectAsState()

    when (val currentState = state) {
        is TrainingListState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is TrainingListState.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp) // Add spacing between items
            ) {
                items(currentState.programs) { program ->
                    TrainingProgramItem(program, onProgramSelected)
                }
            }
        }
        is TrainingListState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = currentState.message, color = Color.Red)
            }
        }
    }
}

@Composable
fun TrainingProgramItem(
    program: TrainingProgram,
    onProgramSelected: (String) -> Unit
) {
    Spacer(modifier = Modifier.height(10.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onProgramSelected(program.id) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Column for text
            Column(
                modifier = Modifier
                    .weight(1f) // Take remaining space
                    .padding(16.dp)
            ) {
                Text(text = program.title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = program.description)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Date: ${program.date}")
            }

            // AsyncImage
            AsyncImage(
                model = program.image,
                contentDescription = "Image",
                modifier = Modifier
                    .size(110.dp) // Fixed size for the image
                    .clip(MaterialTheme.shapes.medium) // Optional: Clip the image to a shape
            )
        }
    }
}