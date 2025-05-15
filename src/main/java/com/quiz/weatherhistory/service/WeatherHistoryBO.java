package com.quiz.weatherhistory.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weatherhistory.domain.WeatherHistory;
import com.quiz.weatherhistory.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistroyMapper;
	
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistroyMapper.selectWeatherHistoryList();
	}
	
	public void addWeatherHistory(String date, String weather, String microDust, double temperatures, double precipitation, double windSpeed) {
		weatherHistroyMapper.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
