package com.quiz.weatherhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weatherhistory.domain.WeatherHistory;
import com.quiz.weatherhistory.service.WeatherHistoryBO;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		List<WeatherHistory> weatherhistoryList = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistroyList", weatherhistoryList);
		
		return "weatherHistory/weatherList";
	}
	
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		
		return "weatherHistory/addWeather";
	}
	
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") String data,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		weatherHistoryBO.addWeatherHistory(data, weather, microDust, temperatures, precipitation, windSpeed);
		
		return "redirect:/weather-history/weather-list-view";
	}
	
}
