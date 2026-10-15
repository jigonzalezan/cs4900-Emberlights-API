package com.emberlights.offthecharts.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class AlbumDto {
  int albumID;
  String albumName;
  String artistName;
}
