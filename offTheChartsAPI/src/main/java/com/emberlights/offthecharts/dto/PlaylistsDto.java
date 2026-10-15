package com.emberlights.offthecharts.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class PlaylistsDto 
{
    Integer playlistID;
    String playlistName;
    GenreDto genres;
    LocalDateTime creationTime;
    Integer numberSongs; 
}