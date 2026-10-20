package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.model.Playlists;
import com.emberlights.offthecharts.repository.PlaylistsRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaylistsService {
  private final PlaylistsRepository playlistsRepository;

  public List<Playlists> getAllPlaylists() {
    return playlistsRepository.findAll();
  }

  public Playlists getPlaylistsById(Integer id) throws EntityNotFoundException {
    return playlistsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Playlist (" + id + ") not found"));
  }

  public List<Playlists> getPlaylistBySearch(String playlistName) {
    return playlistsRepository.findByPlaylistNameContaining(playlistName);
  }
}
