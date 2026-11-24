package com.emberlights.offthecharts.dto;

import java.util.List;
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
  Integer numberSongs;
  List<SongDto> songs;
}
