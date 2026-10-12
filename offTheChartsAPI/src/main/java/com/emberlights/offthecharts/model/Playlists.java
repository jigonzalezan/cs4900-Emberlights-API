package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Playlists")
@AllArgsConstructor
@NoArgsConstructor
public class Playlists {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "playlistID", nullable = false)
  Integer playlistID;

  @Column(name = "playlistName", length = 50, nullable = false)
  String playlistName;

  @JoinColumn(name = "genreID", nullable = false)
  @ManyToOne
  Genres genre;

  @Column(name = "creationTime", nullable = false)
  LocalDateTime creationTime;

  @Column(name = "numberSongs", nullable = false)
  Integer numberSongs;

  @ManyToMany(mappedBy = "playlist")
  Songs[] songs;
}
