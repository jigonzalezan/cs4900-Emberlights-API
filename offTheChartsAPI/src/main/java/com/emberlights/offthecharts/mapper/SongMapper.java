package com.emberlights.offthecharts.mapper;

import com.emberlights.offthecharts.dto.SongDTO;
import com.emberlights.offthecharts.model.Song;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {

  public SongDTO toDTO(Song song) {
    return new SongDTO(
        song.getSongID(),
        song.getSongName(),
        song.getSongDuration().toString(),
        song.getGenre().getGenreID(),
        song.getAlbum().getAlbumID());
  }
}
