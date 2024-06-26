package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// input: x
	// putput: List<weatherHistory>
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
		
	public void addweatherHistory(String date, String weather, String microDust, double temperatures, double precipitation, double windSpeed) {
		weatherHistoryMapper.insertweatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}