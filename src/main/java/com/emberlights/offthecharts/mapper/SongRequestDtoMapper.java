package com.emberlights.offthecharts.mapper;

import com.emberlights.offthecharts.dto.SongRequestDto;
import com.emberlights.offthecharts.model.Songs;
import com.emberlights.offthecharts.service.AlbumService;
import com.emberlights.offthecharts.service.GenreService;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {GenreService.class, AlbumService.class})
public interface SongRequestDtoMapper {
  @Mapping(target = "songID", ignore = true)
  @Mapping(source = "genreID", target = "genre")
  @Mapping(source = "albumID", target = "album")
  @Mapping(target = "playlist", ignore = true)
  Songs toEntity(SongRequestDto songRequestDto) throws EntityNotFoundException;
}
