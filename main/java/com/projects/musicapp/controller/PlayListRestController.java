package com.projects.musicapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.musicapp.model.PlayList;
import com.projects.musicapp.model.Song;
import com.projects.musicapp.service.PlayListService;

@RestController
@RequestMapping("/playlists")
public class PlayListRestController {
	
	@Autowired
	private PlayListService playListService;

	@PostMapping
	public PlayList createPlayList(@RequestBody PlayList playList)
	{
		return playListService.savePlayList(playList);
	}
	
	@GetMapping
	public List<PlayList> getAllPlayLists()
	{
		return playListService.getAllSongs();
	}
	
	@GetMapping("/{playListID}")
	public PlayList getPlayList(@PathVariable Long playListID)
	{
		return playListService.getPlayList(playListID);
	}
	
	@GetMapping("/{playListID}/songs")
	public Set<Song> getSongs(@PathVariable Long playListID)
	{
		return playListService.getSongs(playListID);
	}
	
	@DeleteMapping("/{playListID}/songs/{songID}")
	public void deleteSong(@PathVariable Long playListID, @PathVariable Long songID)
	{
		playListService.deleteSong(playListID, songID);
	}
	
	@DeleteMapping("/{playListID}")
	public void deletePlayList(@PathVariable Long playListID)
	{
		playListService.deletePlayList(playListID);
	}
	
	@PutMapping("/{playListID}")
	public PlayList addSong(@PathVariable Long playListID, @RequestParam("song_id") Long songID)
	{
		return playListService.addSong(playListID, songID);
	}

}
