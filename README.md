# Healthcare Training Enrollment System (MVI Architecture)

This project implements a **Healthcare Training Enrollment System** using **MVI (Model-View-Intent) Architecture** in **Jetpack Compose**. The system allows healthcare practitioners to browse training programs and enroll in them while following clean architecture principles.

## Features

### 1. Training Enrollment System (5 Marks)
- **Training List Screen**:
  - Displays a list of available training programs.
  - Allows users to select a training program.
- **Enrollment Screen**:
  - Enables users to enroll in a selected program.
  - Shows enrollment status.
- **Navigation**:
  - Seamless navigation between the training list and enrollment screens.

### 2. MVI Architecture Implementation (5 Marks)
- **ViewModel**:
  - Manages business logic and state.
- **Flow for State Management**:
  - Observes and updates enrollment status dynamically.
- **Sealed Classes**:
  - Represents different UI states (e.g., `Loading`, `Success`, `Error`).

### 3. Clean Code Principles (5 Marks)
- **UseCase Class**:
  - Handles fetching training programs and processing enrollments.
- **Extension Functions**:
  - Formats dates and enrollment messages.
- **Navigation Component**:
  - Ensures smooth transitions between screens.

## How to Run the Project

### Clone the Repository
```bash
git clone https://github.com/AbdallahLearn/W5D3_MVI_HealthcareTrainingEnrollmentSystem.git
```

### Open the Project
- Open the project in **Android Studio**

### Build and Run
- Build the project and run it on an **emulator** or **physical device**

## Code Structure

- **MainActivity.kt**: Contains navigation setup
- **TrainingListScreen.kt**: UI for displaying training programs
- **EnrollmentScreen.kt**: UI for enrolling in a program
- **TrainingViewModel.kt**: Manages business logic and state
- **UseCase.kt**: Handles data fetching and enrollment logic
- **Navigation.kt**: Manages screen transitions
- **Utils.kt**: Contains helper functions (e.g., date formatting)

## Submission Instructions (5 Marks)
- **GitHub Repository**: Ensure the project is uploaded to GitHub
- **Code Quality**: Follow clean, modular, and well-commented coding standards
- **README.md**: Provide a brief project description and setup instructions
- **Screenshots**: Attach screenshots of successful execution
- **Share Repository Link**: Submit the GitHub repository link along with screenshots

## Dependencies

### Jetpack Compose & Navigation
```gradle
implementation "androidx.navigation:navigation-compose:2.7.7"
```

### Material 3
```gradle
implementation "androidx.compose.material3:material3:1.2.0"
```

## Author
AbdallahLearn

