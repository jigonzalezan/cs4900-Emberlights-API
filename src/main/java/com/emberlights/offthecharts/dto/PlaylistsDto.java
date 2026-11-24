package com.emberlights.offthecharts.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistsDto {
  Integer playlistID;
  String playlistName;
  GenreDto genres;
  LocalDateTime creationTime;
  Integer numberSongs;
}
