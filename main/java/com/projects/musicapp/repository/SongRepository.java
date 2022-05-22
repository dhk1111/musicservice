package com.projects.musicapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.projects.musicapp.model.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	
}
