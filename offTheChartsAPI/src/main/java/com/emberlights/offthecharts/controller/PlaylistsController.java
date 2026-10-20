package com.emberlights.offthecharts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.emberlights.offthecharts.dto.PlaylistsDto;
import com.emberlights.offthecharts.mapper.PlaylistsDtoMapper;
import com.emberlights.offthecharts.service.PlaylistsService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "playlist", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaylistsController 
{
    private final PlaylistsDtoMapper playlistDtoMapper;
    private final PlaylistsService playlistService;

    @GetMapping
    ResponseEntity<List<PlaylistsDto>> getPlaylist() 
    {
        return new ResponseEntity<>(
            playlistDtoMapper.toDtoList(playlistService.getAllPlaylists()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<PlaylistsDto> getPlaylistById(@PathVariable("id") Integer id) 
    {
        return new ResponseEntity<>(
            playlistDtoMapper.toDto(playlistService.getPlaylistsById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "search")
    ResponseEntity<List<PlaylistsDto>> searchSongByName(@RequestParam(required = false) String playlistName) 
    {
        return new ResponseEntity<>(
            playlistDtoMapper.toDtoList(playlistService.getPlaylistBySearch(playlistName)), HttpStatus.OK);
    }
}
