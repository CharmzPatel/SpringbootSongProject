package com.fdmgroup.SpringbootSongProject.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fdmgroup.SpringbootSongProject.exceptions.SongExceptions;
import com.fdmgroup.SpringbootSongProject.model.Song;
import com.fdmgroup.SpringbootSongProject.repositories.SongRepository;

/**
 * Main Controller which manages all the functionalities of webapp using restful
 * api
 * 
 * @author Charmi Patel
 *
 */
@RestController
@RequestMapping()
public class MainRestController {

	@Autowired
	private SongRepository songRepo;

	@GetMapping("/songs/searchByName/{searchterm}")
	public List<Song> search(@PathVariable String searchterm, Model model) {
		List<Song> songs = songRepo.findSongBySearchTerm(searchterm);
		return songs;
	}

	@ManagedOperation(description = "Get all songs in the system")
	@GetMapping("/songs/all")
	public List<Song> getAllSongs() {
		return songRepo.findAll();

	}

	@ManagedOperation(description = "Add a new song")
	@PostMapping("/songs")
	public Song newSong(@RequestBody Song song) {
		Song addedSong = null;
		addedSong = songRepo.save(song);
		return addedSong;
	}

	@DeleteMapping("/songs/{id}")
	public void deleteSong(@PathVariable int id) {
		songRepo.findById(id).orElseThrow(SongExceptions::new);
		songRepo.deleteById(id);

	}

}
