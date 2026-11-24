package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.dto.SongDto;
import com.emberlights.offthecharts.dto.SongRequestDto;
import com.emberlights.offthecharts.mapper.SongDtoMapper;
import com.emberlights.offthecharts.mapper.SongRequestDtoMapper;
import com.emberlights.offthecharts.model.Songs;
import com.emberlights.offthecharts.repository.SongRepository;
import com.emberlights.offthecharts.repository.SongSpecifications;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongService {

  private final SongRepository songRepository;
  private final SongDtoMapper songDtoMapper;
  private final SongRequestDtoMapper songRequestDtoMapper;

  public List<Songs> getAllSongs() {
    return songRepository.findAll();
  }

  public Songs getSongById(Integer id) throws EntityNotFoundException {
    return songRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Song (" + id + ") not found"));
  }

  public List<Songs> searchSongs(SongRequestDto searchCriteria) {
    var spec = SongSpecifications.withCriteria(searchCriteria);
    return songRepository.findAll(spec);
  }

  public Songs getRandomSongByGenre(String genreName) {
    List<Songs> allSongs = songRepository.findByGenreGenreName(genreName);

    if (allSongs == null || allSongs.isEmpty()) {
      System.out.println("Failed to match genre of " + genreName);
      return null;
    }
    Random random = new Random();
    int randomIndex = random.nextInt(allSongs.size());

    Songs randomSong = allSongs.get(randomIndex);

    return randomSong;
  }

  public List<Songs> getMultiRandomSongsByGenre(String genreName, int num) {
    List<Songs> allSongs = songRepository.findByGenreGenreName(genreName);

    if (allSongs == null || allSongs.isEmpty()) {
      System.out.println("Failed to match genre of " + genreName);
    }

    List<Songs> shuffledSongs = new ArrayList<>(allSongs);
    Collections.shuffle(shuffledSongs);

    int count = Math.min(num, shuffledSongs.size());
    return new ArrayList<>(shuffledSongs.subList(0, count));
  }

  public Songs createSong(SongRequestDto songRequestDto) throws EntityNotFoundException {
    return songRepository.saveAndFlush(songRequestDtoMapper.toEntity(songRequestDto));
  }

  public SongDto putSong(Integer id, SongRequestDto songRequestDto) {
    Songs song = songRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Work Order (" + ") not found"));
    Songs updatedSong =
        songRepository.saveAndFlush(songRequestDtoMapper.updateEntity(songRequestDto, song));

    return songDtoMapper.toDto(updatedSong);
  }
}
