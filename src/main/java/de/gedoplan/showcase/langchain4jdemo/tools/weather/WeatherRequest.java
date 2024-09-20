package de.gedoplan.showcase.langchain4jdemo.tools.weather;

public record WeatherRequest(String location, TempUnit unit) {
}
