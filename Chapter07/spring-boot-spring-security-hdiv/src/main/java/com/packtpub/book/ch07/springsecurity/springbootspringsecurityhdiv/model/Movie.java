package com.packtpub.book.ch07.springsecurity.springbootspringsecurityhdiv.model;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	private Long id;
	private String title;
	private String genre;

	public Movie(Long id, String title, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
	}

	public Movie() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
