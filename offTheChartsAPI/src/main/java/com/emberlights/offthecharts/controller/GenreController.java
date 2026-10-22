package com.emberlights.offthecharts.controller;

import com.emberlights.offthecharts.dto.GenreDto;
import com.emberlights.offthecharts.mapper.GenreDtoMapper;
import com.emberlights.offthecharts.service.GenreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "genre", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenreController {

  private final GenreDtoMapper genreDtoMapper;
  private final GenreService genreService;

  @GetMapping
  ResponseEntity<List<GenreDto>> getAllGenres() {
    return new ResponseEntity<>(
        genreDtoMapper.toDtoList(genreService.getAllGenres()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<GenreDto> getGenreById(@PathVariable int id) {
    return new ResponseEntity<>(genreDtoMapper.toDto(genreService.getGenreById(id)), HttpStatus.OK);
  }

  @GetMapping(path = "search")
  ResponseEntity<List<GenreDto>> searchGenreByName(
      @RequestParam(required = false) String genreName) {
    return new ResponseEntity<>(
        genreDtoMapper.toDtoList(genreService.getGenreBySearch(genreName)), HttpStatus.OK);
  }
}
