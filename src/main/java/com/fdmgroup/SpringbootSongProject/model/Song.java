package com.fdmgroup.SpringbootSongProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * All information about the songs
 * 
 * @author Charmi Patel
 *
 */
@Component
@Entity
public class Song {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String genre;
	private String singer;
	private int year;

	public Song() {
		super();
	}

	public Song(int id, String name, String genre, String singer, int year) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.singer = singer;
		this.year = year;
	}

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", genre=" + genre + ", singer=" + singer + ", year=" + year + "]";
	}

}
