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

- `GET /forecast?city={city}&days={days}`: Fetches the weather forecast for the specified city and number of days.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)