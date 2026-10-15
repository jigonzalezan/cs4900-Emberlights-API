package com.emberlights.offthecharts.mapper;

import com.emberlights.offthecharts.dto.AlbumDto;
import com.emberlights.offthecharts.model.Albums;
import com.emberlights.offthecharts.service.AlbumService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {AlbumService.class})
public interface AlbumDtoMapper {

  List<AlbumDto> toDtoList(List<Albums> albumList) throws EntityNotFoundException;
}
