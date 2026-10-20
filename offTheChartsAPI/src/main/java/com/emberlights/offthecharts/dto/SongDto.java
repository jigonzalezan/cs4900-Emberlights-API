package com.emberlights.offthecharts.dto;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class SongDto {
  Integer songID;
  String songName;
  GenreDto genres;
  LocalTime songDuration;
  AlbumDto albums;
}
