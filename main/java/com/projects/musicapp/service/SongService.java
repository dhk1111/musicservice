package com.projects.musicapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.musicapp.model.PlayList;
import com.projects.musicapp.model.Song;
import com.projects.musicapp.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepo;

	public Song saveSong(Song song)
	{
		return (Song) songRepo.save(song);
	}
	
	public Song getSong(Long songID)
	{
		return songRepo.findById(songID).get();
	}
	
	public void deleteSong(Long songID)
	{
		songRepo.deleteById(songID);
	}
	
	public List<Song> getAllSongs()
	{
		List<Song> allSongs = new ArrayList<>();
		songRepo.findAll().forEach(allSongs::add);
		return allSongs;
	}
	
	public Set<PlayList> getPlayLists(Long songID)
	{
		Song song = songRepo.findById(songID).get();
		return song.getPlayLists();
	}

}
