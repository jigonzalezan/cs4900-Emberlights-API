package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalTime;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Songs {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "songID", nullable = false)
  int songID;

  @Column(name = "songName", length = 100, nullable = false)
  String songName;

  @JoinColumn(name = "genreID", nullable = false)
  @ManyToOne
  Genres genre;

  @Column(name = "songDuration", nullable = false)
  LocalTime songDuration;

  @JoinColumn(name = "albumID", nullable = false)
  @ManyToOne
  int albumID;

  @ManyToMany
  @JoinTable(
      name = "PlaylistSongs",
      joinColumns = @JoinColumn(name = "songID", referencedColumnName = "songID"),
      inverseJoinColumns = @JoinColumn(name = "playlistID", referencedColumnName = "playlistID"))
  Playlists[] playlist;
}
