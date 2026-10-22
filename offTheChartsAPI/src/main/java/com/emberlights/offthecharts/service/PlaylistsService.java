package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.dto.PlaylistsDto;
import com.emberlights.offthecharts.mapper.PlaylistsDtoMapper;
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
  private final PlaylistsDtoMapper playlistsDtoMapper;

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

  public Playlists createPlaylists(PlaylistsDto playlistsDto) throws EntityNotFoundException {
    return playlistsRepository.saveAndFlush(playlistsDtoMapper.toEntity(playlistsDto));
  }

  public Playlists putPlaylists(Integer id, PlaylistsDto playlistsDto) {
    Playlists playlists = playlistsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Playlist (" + ") not found"));
    return playlistsRepository.saveAndFlush(
        playlistsDtoMapper.updateEntity(playlistsDto, playlists));
  }
}
