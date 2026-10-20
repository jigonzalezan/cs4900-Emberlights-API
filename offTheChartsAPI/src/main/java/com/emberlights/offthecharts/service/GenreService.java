package com.emberlights.offthecharts.service;

import com.emberlights.offthecharts.model.Genres;
import com.emberlights.offthecharts.repository.GenresRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GenreService {
    private final GenresRepository genresRepository;

    public List<Genres> getAllGenres() {
        return genresRepository.findAll();
    }

    public Genres getGenreById(Integer id) throws EntityNotFoundException {
        return genresRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre (" + id + ") not found"));
    }

    public List<Genres> getGenreBySearch(String genreName) {
        return genresRepository.findByGenreNameContaining(genreName);
    }
}
