package com.emberlights.offthecharts.mapper;

import com.emberlights.offthecharts.dto.PlaylistsRequestDto;
import com.emberlights.offthecharts.model.Playlists;
import com.emberlights.offthecharts.service.GenreService;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {GenreService.class})
public interface PlaylistsRequestDtoMapper {
  @Mapping(target = "playlistID", ignore = true)
  @Mapping(source = "genreID", target = "genres")
  @Mapping(target = "songs", ignore = true)
  Playlists toEntity(PlaylistsRequestDto playlistsRequestDto) throws EntityNotFoundException;

  @InheritConfiguration
  Playlists updateEntity(
      PlaylistsRequestDto playlistsRequestDto, @MappingTarget Playlists playlists)
      throws EntityNotFoundException;
}
