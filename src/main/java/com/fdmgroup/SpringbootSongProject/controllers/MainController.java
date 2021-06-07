package com.fdmgroup.SpringbootSongProject.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.SpringbootSongProject.exceptions.SongExceptions;
import com.fdmgroup.SpringbootSongProject.model.Song;
import com.fdmgroup.SpringbootSongProject.repositories.SongRepository;

/**
 * Main Controller class which takes care of the functionalities of this webapp
 * 
 * @author Charmi Patel
 *
 */

@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private Song song;

	@Autowired
	private SongRepository songRepo;

	@GetMapping("/")
	public String goToHome() {
		return "index";
	}

	@GetMapping("/displaySong")
	public String gotToDisplaySong(Model model) {
		List<Song> songs = songRepo.findAll();
		model.addAttribute("songs", songs);
		return "displaySong";
	}

	@GetMapping("/addSong")
	public String goToAddSong(Model model) {
		model.addAttribute("song", song);
		return "addSong";
	}

	@PostMapping("/processsong")
	public String processProduct(Song song, Model model) {
		model.addAttribute("song", song);
		songRepo.save(song);
		return "confirmation";
	}

	@RequestMapping("/delete")
	public String goToDelete(Model model) {
		return "delete";
	}

	@RequestMapping("/deleteByName")
	public String deleteByName(@RequestParam String searchterm, Model model) {

		try {
			Song deleteSong = songRepo.findByName(searchterm);
			if (deleteSong != null) {
				songRepo.delete(deleteSong);
			} else {
				logger.error("ERROR: No song name found");

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SongExceptions();
		}

		return "index";
	}

	@GetMapping("/search")
	public String search(@RequestParam String searchterm, Model model) {
		List<Song> songs = songRepo.findSongBySearchTerm(searchterm);
		model.addAttribute("songs", songs);
		model.addAttribute("searchterm", searchterm);
		return "searchResults";
	}

}
