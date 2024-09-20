package de.gedoplan.showcase.langchain4jdemo.tools.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MockWeatherInformationService {

  private Logger logger = LoggerFactory.getLogger(MockWeatherInformationService.class);

  private final Map<String, WeatherResponse> temperatureMap = Map.ofEntries(
      Map.entry("Bielefeld", new WeatherResponse.Success("Bielefeld", 20.1, TempUnit.CELSIUS)),
      Map.entry("Berlin", new WeatherResponse.Success("Berlin", 25.6, TempUnit.CELSIUS)),
      Map.entry("Köln", new WeatherResponse.Success("Köln", 27.2, TempUnit.CELSIUS))
  );

  public WeatherResponse apply(WeatherRequest request) {
    logger.info("weatherRequest: {}", request);
    if (request == null) return new WeatherResponse.Failure("Error: Could not parse request.");

    WeatherResponse weatherResponse = temperatureMap.getOrDefault(request.location(), null);
    return switch (weatherResponse) {
      case null -> new WeatherResponse.Failure("Error: No weather information for location " + request.location() + " available.");
      case WeatherResponse.Failure failure -> failure;
      case WeatherResponse.Success success -> success.withTempUnit(request.unit());
    };
  }
}
