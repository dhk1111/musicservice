package com.projects.musicapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PlayList {
	
	@Id
	@GeneratedValue
	private Long playlistid;
	private String playlistname;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "playlist_song_map",
			joinColumns = @JoinColumn(name  = "playlist_id"),
			inverseJoinColumns = @JoinColumn(name = "song_id")
	)
	Set<Song> addedSongs = new HashSet<>();

	
	public Long getPlaylistid() {
		return playlistid;
	}

	public void setPlaylistid(Long playlistid) {
		this.playlistid = playlistid;
	}

	public Set<Song> getAddedSongs() {
		return addedSongs;
	}

	public void setAddedSongs(Set<Song> addedSongs) {
		this.addedSongs = addedSongs;
	}

	public PlayList() {
	}
	
	public PlayList(String playlistname) {
		super();
		this.playlistname = playlistname;
	}

	public String getPlaylistname() {
		return playlistname;
	}

	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}
	
}
