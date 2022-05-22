package com.projects.musicapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long songid;
	private String songname;
	private String duration;
	private String author;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "addedSongs")
	private Set<PlayList> playLists = new HashSet<>();

	public Song() {}
	
	public Set<PlayList> getPlayLists() {
		return playLists;
	}

	public void setPlayLists(Set<PlayList> playLists) {
		this.playLists = playLists;
	}

	public Song(String songname, String duration, String author) {
		super();
		this.songname = songname;
		this.duration = duration;
		this.author = author;
	}
	
	public Long getSongid() {
		return songid;
	}

	public void setSongid(Long songid) {
		this.songid = songid;
	}


	public String getSongname() {
		return songname;
	}
	
	public void setSongname(String songname) {
		this.songname = songname;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
