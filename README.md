# Movie App

A movie app is a mobile application designed to provide users with access to a vast collection of films and TV shows.

## Features

**Browse, see detail, and search for your favorite movies!**

![screenshot1](https://res.cloudinary.com/dsxvvjpi4/image/upload/v1719381976/movie%20app/v6k4ze8ynsnjlli5jg3j.gif)

**Responsive Design**

![screenshot2](https://res.cloudinary.com/dsxvvjpi4/image/upload/v1719386488/responsive_fiibya.gif)

**Dark/Night Mode**

![screenshot3](https://res.cloudinary.com/dsxvvjpi4/image/upload/v1719386736/nightmode_vg1ids.gif)

**Tag and save the movie as your favorite!**

![screenshot4](https://res.cloudinary.com/dsxvvjpi4/image/upload/v1719387039/favorite_kozw6g.gif)


## Installation

To set up and run this project on your local machine, follow these steps:

### Prerequisites

1. **Android Studio**: Make sure you have Android Studio installed on your computer. You can download it from [here](https://developer.android.com/studio).

2. **JDK**: Ensure you have the Java Development Kit (JDK) installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Steps

1. **Clone the repository**:

    Open your terminal or command prompt and run the following command:

    ```sh
    git clone https://github.com/bima-taruna/MovieApp.git
    ```

2. **Open the project in Android Studio**:

    - Open Android Studio.
    - Click on `File > Open`.
    - Navigate to the directory where you cloned the repository and select it.
    - Click `OK` to open the project.

3. **Sync the project with Gradle Files**:

    - Once the project is opened, click on `File > Sync Project with Gradle Files` to ensure all dependencies are downloaded and the project is set up correctly.

4. **Set the API Key**:
    - login or register an account on [this page](https://www.themoviedb.org/) 
    
    - Register an API key from [this page](https://www.themoviedb.org/settings/api) in your account settings page.
    
    - Copy the API Read Access Token
    - Paste in local.properties file in this project
    - Type like this :
    ```sh
    API_KEY= Bearer [YOUR API KEY]
    ```

5. **Run the project**:

    - Connect an Android device to your computer or start an emulator.
    - Click on the `Run` button (green play icon) in Android Studio.
    - Choose the target device and click `OK` to build and run the app.

### Notes

- Ensure your Android SDK is up-to-date by going to `SDK Manager` in Android Studio and installing any necessary updates.
- If you encounter any issues with missing dependencies, open the `build.gradle` file and click on `Sync Now` when prompted by Android Studio.

Congratulations! You should now have the project up and running on your local machine.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
