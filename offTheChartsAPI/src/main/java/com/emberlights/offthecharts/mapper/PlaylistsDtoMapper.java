package com.emberlights.offthecharts.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.emberlights.offthecharts.dto.PlaylistsDto;
import com.emberlights.offthecharts.model.Playlists;
import com.emberlights.offthecharts.service.SongService;
import jakarta.persistence.EntityNotFoundException;

@Mapper(
    componentModel = "spring",
    uses = {SongService.class})
public interface PlaylistsDtoMapper 
{
    Playlists toEntity(PlaylistsDto playlistDto) throws EntityNotFoundException;

    PlaylistsDto toDto(Playlists playlist) throws EntityNotFoundException;

    List<PlaylistsDto> toDtoList(List<Playlists> playlistList) throws EntityNotFoundException;
}