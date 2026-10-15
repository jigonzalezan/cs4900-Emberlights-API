package com.emberlights.offthecharts.repository;

import com.emberlights.offthecharts.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Albums, Integer> {}
