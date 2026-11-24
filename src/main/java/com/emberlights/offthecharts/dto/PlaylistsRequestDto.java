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
public class PlaylistsRequestDto {
  Integer playlistID;
  String playlistName;
  Integer genreID;
  LocalDateTime creationTime;
  Integer numberSongs;
}
