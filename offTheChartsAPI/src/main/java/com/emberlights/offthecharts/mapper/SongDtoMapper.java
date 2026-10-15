package com.emberlights.offthecharts.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.emberlights.offthecharts.dto.SongDto;
import com.emberlights.offthecharts.model.Songs;
import com.emberlights.offthecharts.service.SongService;
import jakarta.persistence.EntityNotFoundException;

@Mapper(
    componentModel = "spring",
    uses = {SongService.class})
public interface SongDtoMapper 
{
    Songs toEntity(SongDto songDto) throws EntityNotFoundException;

    SongDto toDto(Songs song) throws EntityNotFoundException;

    List<SongDto> toDtoList(List<Songs> songList) throws EntityNotFoundException;
}
