package com.emberlights.offthecharts.controller;

import com.emberlights.offthecharts.dto.SongDto;
import com.emberlights.offthecharts.mapper.SongDtoMapper;
import com.emberlights.offthecharts.service.SongService;
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
@RequestMapping(path = "song", produces = MediaType.APPLICATION_JSON_VALUE)
public class SongController {
  private final SongDtoMapper songDtoMapper;
  private final SongService songService;

  @GetMapping
  ResponseEntity<List<SongDto>> getAllSongs() {
    return new ResponseEntity<>(songDtoMapper.toDtoList(songService.getAllSongs()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<SongDto> getSongById(@PathVariable("id") Integer id) {
    return new ResponseEntity<>(songDtoMapper.toDto(songService.getSongsById(id)), HttpStatus.OK);
  }

  @GetMapping(path = "search")
  ResponseEntity<List<SongDto>> searchSongByName(@RequestParam(required = false) String songName) {
    return new ResponseEntity<>(
        songDtoMapper.toDtoList(songService.getSongsBySearch(songName)), HttpStatus.OK);
  }
}
