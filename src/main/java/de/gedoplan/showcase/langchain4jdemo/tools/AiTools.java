package de.gedoplan.showcase.langchain4jdemo.tools;

import de.gedoplan.showcase.langchain4jdemo.tools.traffic.*;
import de.gedoplan.showcase.langchain4jdemo.tools.weather.MockWeatherInformationService;
import de.gedoplan.showcase.langchain4jdemo.tools.weather.TempUnit;
import de.gedoplan.showcase.langchain4jdemo.tools.weather.WeatherRequest;
import de.gedoplan.showcase.langchain4jdemo.tools.weather.WeatherResponse;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AiTools {

  @Tool("Get current weather information for location.")
  public WeatherResponse getCurrentWeather(@P("Request location") String location, @P(value = "Request unit", required = false) TempUnit unit) {
    return new MockWeatherInformationService().apply(new WeatherRequest(location, unit));
  }
//  public WeatherResponse getCurrentWeather(@P("Request includes location and temperature unit.") WeatherRequest request) {
//    return new MockWeatherInformationService().apply(request);
//  }

  @Tool("Get traffic information for motorway.")
  public List<TrafficResponse> getTrafficInformation(@P("Request motorway") Motorway motorway,
                                                     @P(value = "Request length unit", required = false) LengthUnit unit) {
    return new MockTrafficInformationService().apply(new TrafficRequest(motorway, unit));
  }
//  public List<TrafficResponse> getTrafficInformation(@P("Request includes motorway and length unit.") TrafficRequest request) {
//    return new MockTrafficInformationService().apply(request);
//  }
}
