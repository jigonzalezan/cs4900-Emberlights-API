package com.emberlights.offthecharts.repository;

import com.emberlights.offthecharts.model.Playlists;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistsRepository extends JpaRepository<Playlists, Integer> 
{
  List<Playlists> findByPlaylistNameContaining(String playlistName);
}
