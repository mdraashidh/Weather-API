# Weather API 🌤️

A Spring Boot REST API that gets live weather data from **Open-Meteo** and returns it in a simple format.

## What the project does

The application supports:

- Current weather
- Daily weather forecast
- Third-party API integration
- Caching with Caffeine
- Configuration using environment variables
- Basic exception handling
- Swagger / OpenAPI
- JUnit + Mockito testing

---

## How it works

For:

```http
GET /api/weather?city=Chennai
```

the flow is:

```text
Client
  ↓
Controller
  ↓
Service
  ↓
Weather API Client
  ↓
Open-Meteo
  ↓
Weather data
  ↓
Our DTO
  ↓
Client
```

For a city name, the application first gets the city's **latitude and longitude** from the Open-Meteo Geocoding API, then uses those coordinates to get weather data.

---

## API Endpoints

### 1. Current Weather

```http
GET /api/weather?city=Chennai
```

Example response:

```json
{
  "city": "Chennai",
  "temperature": 31.5,
  "feelsLike": 34.2,
  "windSpeed": 12.4,
  "humidity": 78.0,
  "condition": "Partly cloudy"
}
```

### 2. Weather Forecast

```http
GET /api/weather/forecast?city=Chennai
```

Example response:

```json
{
  "city": "Chennai",
  "forecast": [
    {
      "date": "2026-09-11",
      "maxTemperature": 32.5,
      "minTemperature": 27.1,
      "condition": "Partly cloudy"
    },
    {
      "date": "2026-09-12",
      "maxTemperature": 33.1,
      "minTemperature": 27.4,
      "condition": "Clear sky"
    }
  ]
}
```

---

## Project Structure

```text
com.raashidh.weather_api
│
├── client       → Calls Open-Meteo
├── controller   → Handles HTTP requests
├── service      → Business logic
├── dto          → Request/response data objects
├── exception    → Custom exception handling
├── config       → Application configuration
└── util         → Reusable helper logic
```

### Simple responsibility

```text
Controller → What request came in?
Service    → What should the application do?
Client     → How do we call the external API?
DTO        → What data are we sending?
Config     → Where does configuration come from?
Util       → Reusable helper logic
```

---

## Caching

The current weather result is cached using **Caffeine**.

### Without cache

```text
Request → Open-Meteo
Request → Open-Meteo
Request → Open-Meteo
```

### With cache

```text
First request  → Open-Meteo → Save in cache
Next request   → Cache
Next request   → Cache
```

The cache key is normalized, so:

```text
Chennai
chennai
 CHENNAI
```

use the same cache key.

---

## Configuration

Weather API URLs are stored in `application.properties`:

```properties
weather.geocoding-url=${WEATHER_GEOCODING_URL:https://geocoding-api.open-meteo.com/v1/search}
weather.forecast-url=${WEATHER_FORECAST_URL:https://api.open-meteo.com/v1/forecast}
```

This allows environment variables to override the default values.

---

## Testing

The project uses:

- **JUnit** for tests
- **Mockito** for mocking dependencies

For example, the weather-code mapper is tested with cases such as:

```text
0  → Clear sky
2  → Partly cloudy
63 → Rain
95 → Thunderstorm
```

Mockito is used to test `WeatherService` without calling the real external API.

---

## Swagger

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

---

## Tech Stack

```text
Java
Spring Boot
Spring Web
RestClient
Spring Cache
Caffeine
Maven
JUnit
Mockito
Swagger / OpenAPI
Open-Meteo
```

---

## Run the Project

Run:

```text
WeatherApiApplication
```

The application starts on:

```text
http://localhost:8080
```

Try:

```text
http://localhost:8080/api/weather?city=Chennai
```

or:

```text
http://localhost:8080/api/weather/forecast?city=Chennai
```

---

## Why I built this project

The main goal is to learn real Spring Boot backend development through a practical project:

```text
REST API
   ↓
External API
   ↓
DTO Mapping
   ↓
Service Layer
   ↓
Caching
   ↓
Configuration
   ↓
Testing
```

More features will be added step by step.

---

## Future Improvements

Possible next features:

- Better exception handling
- More unit and integration tests
- Redis caching
- Rate limiting
- Docker
- CI/CD
- React frontend
- Deployment

---

## Weather Provider

Weather data comes from **Open-Meteo**:

https://open-meteo.com/
