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
import java.time.LocalTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Songs")
@AllArgsConstructor
@NoArgsConstructor
public class Songs {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "songID", nullable = false)
  Integer songID;

  @Column(name = "songName", length = 100, nullable = false)
  String songName;

  @JoinColumn(name = "genreID", nullable = false)
  @ManyToOne
  Genres genre;

  @Column(name = "songDuration", nullable = false)
  LocalTime songDuration;

  @JoinColumn(name = "albumID", nullable = false)
  @ManyToOne
  Albums album;

  @EqualsAndHashCode.Exclude
  @ManyToMany
  @JoinTable(name = "PlaylistSongs", joinColumns = @JoinColumn(name = "songID", referencedColumnName = "songID"), inverseJoinColumns = @JoinColumn(name = "playlistID", referencedColumnName = "playlistID"))
  Set<Playlists> playlist;
}
