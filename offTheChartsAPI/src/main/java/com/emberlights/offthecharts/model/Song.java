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
import java.time.LocalTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Songs")
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "songID", nullable = false)
  private Integer songID;

  @Column(name = "songName", length = 100, nullable = false)
  private String songName;

  @ManyToOne
  @JoinColumn(name = "genreID", nullable = false)
  private Genre genre;

  @Column(name = "songDuration", nullable = false)
  private LocalTime songDuration;

  @ManyToOne
  @JoinColumn(name = "albumID", nullable = false)
  private Album album;

  @ManyToMany(mappedBy = "songs")
  private Set<Playlist> playlists;
}
