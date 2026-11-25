package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.dto.PlaylistsDto;
import com.emberlights.offthecharts.dto.PlaylistsRequestDto;
import com.emberlights.offthecharts.mapper.PlaylistsDtoMapper;
import com.emberlights.offthecharts.mapper.PlaylistsRequestDtoMapper;
import com.emberlights.offthecharts.mapper.SongDtoMapper;
import com.emberlights.offthecharts.model.Genres;
import com.emberlights.offthecharts.model.Playlists;
import com.emberlights.offthecharts.model.Songs;
import com.emberlights.offthecharts.repository.PlaylistsRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaylistsService {
  private final PlaylistsRepository playlistsRepository;
  private final PlaylistsDtoMapper playlistsDtoMapper;
  private final PlaylistsRequestDtoMapper playlistsRequestDtoMapper;

  private final SongService songService;
  private final GenreService genreService;
  private final SongDtoMapper songDtoMapper;

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

  public PlaylistsDto createPlaylists(PlaylistsRequestDto playlistsDto)
      throws EntityNotFoundException {
    // Get the genre name
    Genres genre = genreService.getGenreById(playlistsDto.getGenreID());

    // Get random songs
    List<Songs> randomSongs =
        songService.getMultiRandomSongsByGenre(genre.getGenreName(), playlistsDto.getNumberSongs());

    Playlists playlists = playlistsRequestDtoMapper.toEntity(playlistsDto);
    playlists.setGenres(genre);
    playlists.setSongs(new ArrayList<>());

    if (randomSongs.size() != playlistsDto.getNumberSongs())
      throw new IllegalStateException("Cannot populate playlist");

    for (Songs song : randomSongs) {
      playlists.addSong(song);
    }

    return playlistsDtoMapper.toDto(playlistsRepository.saveAndFlush(playlists));
  }

  public PlaylistsDto putPlaylists(Integer id, PlaylistsRequestDto playlistsRequestDto) {
    Playlists playlists = playlistsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Playlist (" + id + ") not found"));
    Playlists updatePlaylists = playlistsRepository.saveAndFlush(
        playlistsRequestDtoMapper.updateEntity(playlistsRequestDto, playlists));

    return playlistsDtoMapper.toDto(updatePlaylists);
  }
}
