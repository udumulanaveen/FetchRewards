Fetch Rewards Android Coding Exercise

This is a simple Android app built with Kotlin and Jetpack Compose to fulfill the requirements of the Fetch Rewards coding exercise. The app retrieves data from a remote API, filters out items with empty or null names, sorts them by listId and name, and displays them in an easy-to-read list.

Features:

Kotlin programming language
Jetpack Compose for UI
Retrofit for network requests
State management with ViewModel and Jetpack Compose's state handling
Coroutines for asynchronous data fetching
Filtering and sorting of data

Requirements

Display items grouped by listId
Sort the items by listId and name
Filter out items where the name is null or blank
Use the latest tools (Jetpack Compose, Kotlin)

Tech Stack

Kotlin: Modern, concise programming language
Jetpack Compose: Declarative UI framework for Android
Retrofit: Networking library to make API requests
Coroutines: Asynchronous programming for handling background tasks
ViewModel: Lifecycle-aware component for managing UI-related data

API

The app fetches a list of items from the following URL:
https://fetch-hiring.s3.amazonaws.com/hiring.json


How It Works

Data Fetching: The app uses Retrofit to make a network request to fetch the data from the provided API URL.
Filtering and Sorting: The retrieved data is filtered to remove items with null or blank name fields. The remaining data is sorted first by listId and then by name.
Displaying Data: The filtered and sorted items are displayed in a LazyColumn using Jetpack Compose.
State Management: The app uses a ViewModel to fetch the data and store the filtered items. The ViewModel uses Coroutines to handle data fetching in the background.

Screenshots
![Screenshot_20241024_121900](https://github.com/user-attachments/assets/2d351d56-36b7-4607-b1b7-8514d95c6aae)


Installation
Clone the repository:


git clone https://github.com/yourusername/FetchRewardsApp.git
cd FetchRewardsApp
Open the project in Android Studio.

Build and run the project on an emulator or physical device.

Minimum SDK: Android 21 (Lollipop)

Dependencies
Make sure to have the following dependencies installed in your build.gradle:

dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.activity:activity-compose:1.6.0")
    implementation ("androidx.compose.ui:ui:1.3.0")
    implementation ("androidx.compose.material:material:1.3.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
}

How to Run

Run the app: Once you've opened the project in Android Studio, click on the "Run" button to compile and launch the app.
View the list: The app will fetch the data from the API and display it in a scrollable list grouped and sorted as required.

Testing

The app can be extended to include unit tests for filtering and sorting logic.
Consider adding instrumentation tests for UI using ComposeTestRule.

Future Improvements

Error handling: Add better error handling for network issues.
Loading states: Show a loading indicator while data is being fetched.
Pagination: If the API supports pagination, implement lazy loading to handle large data sets.

Unit Tests: Extend the app with unit tests to verify sorting and filtering logic.
