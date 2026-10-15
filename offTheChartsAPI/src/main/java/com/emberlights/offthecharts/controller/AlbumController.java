package com.emberlights.offthecharts.controller;

import com.emberlights.offthecharts.dto.AlbumDto;
import com.emberlights.offthecharts.mapper.AlbumDtoMapper;
import com.emberlights.offthecharts.service.AlbumService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.MediaType;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor 
@RestController 
@RequestMapping (path = "album", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlbumController {

  private final AlbumDtoMapper albumDtoMapper;
  private final AlbumService albumService;

  @GetMapping
  ResponseEntity<List<AlbumDto>> getAllAlbums() {
    return new ResponseEntity<>(
        albumDtoMapper.toDtoList(albumService.getAllAlbums()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<AlbumDto> getAlbumById(@PathVariable int id) {
    return new ResponseEntity<>(
      albumDtoMapper.toDto(albumService.getAlbumById(id)), HttpStatus.OK
    );
  }

  @GetMapping(path = "search")
  ResponseEntity<List<AlbumDto>> searchAlbumByName(@RequestParam(required = false) String albumName) {
    return new ResponseEntity<>(
      albumDtoMapper.toDtoList(albumService.searchAlbums(albumName)), HttpStatus.OK);
  }
}
