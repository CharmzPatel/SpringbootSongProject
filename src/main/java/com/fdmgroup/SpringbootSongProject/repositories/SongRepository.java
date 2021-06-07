package com.fdmgroup.SpringbootSongProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.SpringbootSongProject.model.Song;

/**
 * Methods showing how songs are stored
 * 
 * @author Charmi Patel
 *
 */
public interface SongRepository extends JpaRepository<Song, Integer> {

	public Song findByName(String name);

	@Query("select s from Song s where " + "lower(s.name) like lower(concat('%',:searchTerm, '%')) or "
			+ "lower(s.genre) like lower(concat('%',:searchTerm, '%'))")
	List<Song> findSongBySearchTerm(@Param("searchTerm") String searchTerm);

}
