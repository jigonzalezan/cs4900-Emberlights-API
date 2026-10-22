package com.emberlights.offthecharts.dto;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class SongRequestDto {
  Integer songID;
  String songName;
  Integer genreID;
  LocalTime songDuration;
  Integer albumID;
}
