package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.model.Songs;
import com.emberlights.offthecharts.repository.SongRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongService {

  private final SongRepository songRepository;

  public List<Songs> getAllSongs() {
    return songRepository.findAll();
  }

  public Songs getSongById(Integer id) throws EntityNotFoundException {
    return songRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Song (" + id + ") not found"));
  }

  public List<Songs> searchSongs(String songName) {
    return songRepository.findBySongNameContaining(songName);
  }

  public Songs getRandomSongByGenre(String genreName) {
    List<Songs> allSongs = songRepository.findByGenreGenreName(genreName);
    Random random = new Random();
    int randomIndex = random.nextInt(allSongs.size());

    Songs randomSong = allSongs.get(randomIndex);

    return randomSong;
  }
}
