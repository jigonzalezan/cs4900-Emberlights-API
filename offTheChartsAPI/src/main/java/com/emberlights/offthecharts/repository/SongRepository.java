package com.emberlights.offthecharts.repository;

import com.emberlights.offthecharts.model.Songs;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Songs, Integer> 
{
  List<Songs> findBySongName(String songName);
}