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
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Playlists")
public class Playlist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "playlistID", nullable = false)
  private Integer playlistID;

  @Column(name = "playlistName", length = 50, nullable = false)
  private String playlistName;

  @ManyToOne
  @JoinColumn(name = "genreID", nullable = false)
  private Genre genre;

  @Column(name = "creationTime", nullable = false)
  private LocalDateTime creationTime;

  @Column(name = "numberSongs", nullable = false)
  private Integer numberSongs = 10;

  @ManyToMany
  @JoinTable(
      name = "PlaylistSongs",
      joinColumns = @JoinColumn(name = "playlistID"),
      inverseJoinColumns = @JoinColumn(name = "songID"))
  private Set<Song> songs = new HashSet<>();
}
