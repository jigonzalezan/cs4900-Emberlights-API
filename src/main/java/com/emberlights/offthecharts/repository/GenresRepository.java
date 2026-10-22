package com.emberlights.offthecharts.repository;

import com.emberlights.offthecharts.model.Genres;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer> {
  List<Genres> findByGenreNameContaining(String genreName);
}
