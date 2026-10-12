package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Playlists {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "playlistID", nullable = false)
  int playlistID;

  @Column(name = "playlistName", length = 50, nullable = false)
  String playlistName;

  @JoinColumn(name = "genreID", nullable = false)
  @ManyToOne
  Genres genre;

  @Column(name = "creationTime", nullable = false)
  LocalDateTime creationTime;

  @Column(name = "numberSongs", nullable = false)
  int numberSongs;

  @ManyToMany(mappedBy = "playlist")
  Songs[] songs;
}
