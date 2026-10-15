package com.emberlights.offthecharts.repository;

import com.emberlights.offthecharts.model.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {

  List<Song> findBySongNameContainingIgnoreCase(String name);
}
