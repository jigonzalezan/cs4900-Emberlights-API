package com.emberlights.offthecharts.mapper;

import com.emberlights.offthecharts.dto.AlbumDto;
import com.emberlights.offthecharts.model.Albums;
import com.emberlights.offthecharts.service.AlbumService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {AlbumService.class})
public interface AlbumDtoMapper {

  List<AlbumDto> toDtoList(List<Albums> albumList) throws EntityNotFoundException;

  AlbumDto toDto(Albums albums) throws EntityNotFoundException;

  Albums toEntity(AlbumDto albumDto) throws EntityNotFoundException;

  @Mapping(target = "albumID", ignore = true)
  Albums update(@MappingTarget Albums album, Albums updateAlbum) throws EntityNotFoundException;
}
