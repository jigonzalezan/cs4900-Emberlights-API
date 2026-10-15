package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.dto.SongDTO;
import com.emberlights.offthecharts.mapper.SongMapper;
import com.emberlights.offthecharts.repository.SongRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SongService {

  private final SongRepository repository;
  private final SongMapper mapper;

  public SongService(SongRepository repository, SongMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<SongDTO> getAllSongs() {
    return repository.findAll().stream().map(mapper::toDTO).toList();
  }

  public SongDTO getSongById(Integer id) {
    return repository
        .findById(id)
        .map(mapper::toDTO)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found"));
  }

  public List<SongDTO> getSongsByName(String name) {
    return repository.findBySongNameContainingIgnoreCase(name).stream()
        .map(mapper::toDTO)
        .toList();
  }
}
