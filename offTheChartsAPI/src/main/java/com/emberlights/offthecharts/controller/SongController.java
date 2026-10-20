package com.emberlights.offthecharts.controller;

import com.emberlights.offthecharts.dto.SongDto;
import com.emberlights.offthecharts.mapper.SongDtoMapper;
import com.emberlights.offthecharts.model.Songs;
import com.emberlights.offthecharts.service.SongService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "song", produces = MediaType.APPLICATION_JSON_VALUE)
public class SongController {

  private final SongDtoMapper songDtoMapper;
  private final SongService songService;

  @GetMapping
  ResponseEntity<List<SongDto>> getAllSongs() {
    return new ResponseEntity<>(songDtoMapper.toDtoList(songService.getAllSongs()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<SongDto> getSongById(@PathVariable Integer id) {
    return new ResponseEntity<>(songDtoMapper.toDto(songService.getSongById(id)), HttpStatus.OK);
  }

  @GetMapping(path = "search")
  ResponseEntity<List<SongDto>> searchSongByName(@RequestParam(required = false) String songName) {
    return new ResponseEntity<>(
        songDtoMapper.toDtoList(songService.searchSongs(songName)), HttpStatus.OK);
  }

  // Get a random song for the playlist switching
  @GetMapping(path = "random")
  ResponseEntity<SongDto> randomSongByGenre(@RequestParam(required = true) String genreName) {
    return new ResponseEntity<>(
        songDtoMapper.toDto(songService.getRandomSongByGenre(genreName)), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> createSong(@RequestBody SongDto songDTO) {
    Songs song;
    try {
      song = songService.createSong(songDTO);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(song, HttpStatus.CREATED);
  }
}
