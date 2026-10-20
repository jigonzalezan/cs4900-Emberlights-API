package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.model.Songs;
import com.emberlights.offthecharts.repository.SongRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongService {
  private final SongRepository songRepository;

  public List<Songs> getAllSongs() {
    return songRepository.findAll();
  }

  public Songs getSongsById(Integer id) throws EntityNotFoundException {
    return songRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Song (" + id + ") not found"));
  }

  public List<Songs> getSongsBySearch(String songName) {
    return songRepository.findBySongName(songName);
  }
}
