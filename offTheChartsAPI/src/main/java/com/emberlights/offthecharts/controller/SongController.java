package com.emberlights.offthecharts.controller;

import com.emberlights.offthecharts.dto.SongDTO;
import com.emberlights.offthecharts.service.SongService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongController {

  private final SongService service;

  public SongController(SongService service) {
    this.service = service;
  }

  @GetMapping
  public List<SongDTO> getAllSongs() {
    return service.getAllSongs();
  }

  @GetMapping("/{id}")
  public SongDTO getSongById(@PathVariable Integer id) {
    return service.getSongById(id);
  }

  @GetMapping("/search")
  public List<SongDTO> getSongsByName(@RequestParam String name) {
    return service.getSongsByName(name);
  }
}
