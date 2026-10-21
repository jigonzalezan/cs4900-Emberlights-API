package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.dto.AlbumDto;
import com.emberlights.offthecharts.mapper.AlbumDtoMapper;
import com.emberlights.offthecharts.model.Albums;
import com.emberlights.offthecharts.repository.AlbumRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AlbumService {

  // AlbumRepository albumRepository = new AlbumRepository();
  private final AlbumRepository albumRepository;
  private final AlbumDtoMapper albumDtoMapper;

  public List<Albums> getAllAlbums() {
    return albumRepository.findAll();
  }

  public Albums getAlbumById(int id) throws EntityNotFoundException {
    return albumRepository
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album not found: " + id));
  }

  public List<Albums> searchAlbums(String albumName) {
    return albumRepository.findByAlbumName(albumName);
  }

  public Albums createAlbum(AlbumDto newAlbum) throws EntityNotFoundException{
    return albumRepository.saveAndFlush(albumDtoMapper.toEntity(newAlbum));
  }
}
