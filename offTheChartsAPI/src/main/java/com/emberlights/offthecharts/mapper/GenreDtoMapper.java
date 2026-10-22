package com.emberlights.offthecharts.mapper;

import com.emberlights.offthecharts.dto.GenreDto;
import com.emberlights.offthecharts.model.Genres;
import com.emberlights.offthecharts.service.GenreService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {GenreService.class})
public interface GenreDtoMapper {

  List<GenreDto> toDtoList(List<Genres> genreList) throws EntityNotFoundException;

  GenreDto toDto(Genres genres) throws EntityNotFoundException;
}
