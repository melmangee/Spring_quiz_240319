package com.quiz.lesson06.domain;

import java.time.LocalDateTime;

public class Bookmark {
	private int id;
	private String name;
	private String url;
	private LocalDateTime created_At;
	private LocalDateTime updated_At;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDateTime getCreated_At() {
		return created_At;
	}
	public void setCreated_At(LocalDateTime created_At) {
		this.created_At = created_At;
	}
	public LocalDateTime getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(LocalDateTime updated_At) {
		this.updated_At = updated_At;
	}
	
	
}
