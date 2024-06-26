# Weather Forecast Application

This application provides weather forecast data for a specified city and number of days.

## Principle from 12 Factor App

This application follows the [12 Factor App](https://12factor.net/) methodology. Specifically, it adheres to the principle of "Config" which states that the configuration that varies between deployments should be stored in the environment. This is evident from the use of `application.properties` file where we store API keys, default city, and other configuration details.

## Design Pattern

The application follows the Service Oriented Architecture (SOA) design pattern. The services like `WeatherAPIClient`, `WeatherEntryAggregator`, `WeatherResponseCreator`, and `MessageAdder` are loosely coupled and each has a specific role, making the application modular and easy to maintain.

## Instructions to Run the Project

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Update the `application.properties` file with your OpenWeatherMap API key and other configuration details.
4. Build the project using Maven. Run the command: `mvn clean install`.
5. After successful build, run the application using the command: `java -jar target/your-artifactId-version.jar`.
6. The application will start running at `http://localhost:8080`.

Please ensure you have Java and Maven installed on your machine before running the project.

## API Endpoints

- `GET /api/weather?city={city}&days={days}`: Fetches the weather forecast for the specified city and number of days.



## API Documentation

You can find the API documentation at [Swagger UI](http://localhost:8080/swagger-ui/index.html) when the application is running. It provides a detailed description of the API endpoints, request/response models, and allows you to try out the API calls directly from the browser.



## Configuration and Profiles

This application uses environment variables and Spring profiles for configuration. The `application.properties` file contains the default configuration. The application fetches values from environment variables if they are set, otherwise, it uses the default values specified in the `application.properties` file.

The application also supports different profiles, each with its own configuration. These configurations are specified in `application-{profile}.properties` files. When a profile is active, the application uses the configuration from the corresponding `application-{profile}.properties` file, overriding the same properties in the `application.properties` file.

To run the application with a specific profile, use the `-Dspring.profiles.active={profile}` argument when starting the application. For example, to run the application with the `preprod` profile, use the command: `java -jar target/your-artifactId-version.jar -Dspring.profiles.active=preprod`.


## Test Cases

The service includes test cases to ensure the functionality of the `MessageAdder` class. These test cases check the messages returned by the `getMessage` method under different weather conditions.

To run the test cases, use the following command: `mvn test`.