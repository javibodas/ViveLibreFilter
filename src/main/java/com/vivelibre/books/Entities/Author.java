package com.vivelibre.books.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
	
	private String name;
	
	private String surName;
	
	private String bio;

	@JsonCreator
	public Author(
			@JsonProperty("name") String name, 
			@JsonProperty("surName") String surName, 
			@JsonProperty("bio") String bio
	) {
		this.name = name;
		this.surName = surName;
		this.bio = bio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
