package com.emberlights.offthecharts.dto;

import com.emberlights.offthecharts.model.Albums;
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
  GenreDto genre;
  LocalTime songDuration;
  Albums album;
}
