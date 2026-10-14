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

  public List<Songs> getSongs(String songName) {
    if (songName == null || songName.isBlank()) {
      return songRepository.findAll();
    }
    return songRepository.findBySongName(songName);
  }

  public Songs getSongById(Integer id) throws EntityNotFoundException {
    return songRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Song (" + id + ") not found"));
  }
}
