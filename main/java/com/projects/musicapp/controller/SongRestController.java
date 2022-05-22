package com.projects.musicapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.musicapp.model.PlayList;
import com.projects.musicapp.model.Song;
import com.projects.musicapp.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongRestController {
	
	@Autowired
	private SongService songService;
	
	@PostMapping
	public Song createSong(@RequestBody Song song)
	{
		return songService.saveSong(song);
	}
	
	@GetMapping
	public List<Song> getAllSongs()
	{
		return songService.getAllSongs();
	}
	
	@GetMapping("/{songID}")
	public Song getSong(@PathVariable Long songID)
	{
		return songService.getSong(songID);
	}
	
	@DeleteMapping("/{songID}")
	public void deleteSong(@PathVariable Long songID)
	{
		songService.deleteSong(songID);
	}
	
	@GetMapping("/{songID}/playlists")
	public Set<PlayList> getPlayLists(@PathVariable Long songID)
	{
		return songService.getPlayLists(songID);
	}

}
