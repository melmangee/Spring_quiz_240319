package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	WeatherHistoryBO weatherHistoryBO;

	// 날씨 목록 화면 http://localhost:8080/weather-history/weather-list-view
		@GetMapping("/weather-list-view")
		public String weatherListView(Model model) {
			
			// select DB
			List<WeatherHistory> WeatherHistoryList =  weatherHistoryBO.getWeatherHistoryList();
			
			// model 담기
			model.addAttribute("WeatherHistoryList", WeatherHistoryList);
			
			// 화면 이동
			return "weather_history/weatherList";
		}
		
		// 날씨 추가 화면 http://localhost:8080/weather-history/add-weather-view
		@GetMapping("/add-weather-view")
		public String addWeatherView() {
			return "weather_history/addWeather";
		}
		
		// 날씨 추가 기능 / weather-history/add-weather
		@PostMapping("/add-weather")
		public String addWeather(
				//@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
				@RequestParam("date") String date, // LocalDate도 됨 Date면 위처럼 쓴다.
				@RequestParam("weather") String weather, 
				@RequestParam("microDust") String microDust, 
				@RequestParam("temperatures") double temperatures, 
				@RequestParam("precipitation") double precipitation, 
				@RequestParam("windSpeed") double windSpeed ) {
			
			// db insert
			weatherHistoryBO.addweatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
			
			// redirect => 날씨 목록
			return "redirect:/weather-history/weather-list-view";
		}
		
		
}