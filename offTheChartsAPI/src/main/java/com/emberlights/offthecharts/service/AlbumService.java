package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.model.Albums;
import com.emberlights.offthecharts.repository.AlbumRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  
public class AlbumService {

    // AlbumRepository albumRepository = new AlbumRepository();
    private final AlbumRepository albumRepository;

    public List<Albums> getAllAlbums() {
        return albumRepository.findAll();
    }
}
