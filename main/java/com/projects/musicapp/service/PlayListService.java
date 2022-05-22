package com.projects.musicapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.musicapp.model.PlayList;
import com.projects.musicapp.model.Song;
import com.projects.musicapp.repository.PlayListRepository;
import com.projects.musicapp.repository.SongRepository;

@Service
public class PlayListService {
	
	@Autowired
	private PlayListRepository playListRepo;
	@Autowired
	private SongRepository songRepo;
	
	public PlayList savePlayList(PlayList playList)
	{
		return playListRepo.save(playList);
	}
	
	public PlayList getPlayList(Long playListID)
	{
		return playListRepo.findById(playListID).get();
	}
	
	public void deletePlayList(Long playListID)
	{
		playListRepo.deleteById(playListID);
	}
	
	public void deleteSong(Long playListID, Long songID)
	{
		PlayList playList = playListRepo.findById(playListID).get();
		Song song = songRepo.findById(songID).get();
		playList.getAddedSongs().remove(song);
		playListRepo.save(playList);
	}
	
	public PlayList addSong(Long playListID, Long songID)
	{
		PlayList playList = playListRepo.findById(playListID).get();
		Song song = songRepo.findById(songID).get();
		playList.getAddedSongs().add(song);
		return playListRepo.save(playList);
	}
	
	public Set<Song> getSongs(Long palyListID)
	{
		PlayList playList = playListRepo.findById(palyListID).get();
		return playList.getAddedSongs();
	}
	
	public List<PlayList> getAllSongs()
	{
		List<PlayList> playLists = new ArrayList<>();
		playListRepo.findAll().forEach(playLists::add);
		return playLists;
	}


}
