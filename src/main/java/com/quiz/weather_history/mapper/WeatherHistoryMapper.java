package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	
	public List<WeatherHistory> selectWeatherHistoryList();
	
//	public int insertWeatherHistory(WeatherHistory weatherHistory);
//	
//		public WeatherHistory selectWeatherHistory();
}
