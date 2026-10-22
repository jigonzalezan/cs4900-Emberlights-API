package com.emberlights.offthecharts.repository;

import com.emberlights.offthecharts.model.Albums;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Albums, Integer> {
  List<Albums> findByAlbumName(String albumName);
}
