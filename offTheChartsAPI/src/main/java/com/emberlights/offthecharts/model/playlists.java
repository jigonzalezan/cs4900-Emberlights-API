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
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Data
@Entity
@Table(name = "Playlists")
public class Playlists {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int playlistID;

  @Column(name = "playlistName", nullable = false, length = 50)
  private String playlistName;

  @Column(name = "creationTime", nullable = false)
  @CreationTimestamp(source = SourceType.DB)
  Instant creationTime;

  @Column(name = "numberSongs", nullable = false)
  private int numberSongs;

  @JoinColumn(name = "albumID", nullable = false)
  @ManyToOne
  Albums album;

  @JoinTable(
      name = "playlist_songs",
      joinColumns = @JoinColumn(name = "playlistID", referencedColumnName = "playlistID"),
      inverseJoinColumns = @JoinColumn(name = "songID", referencedColumnName = "songID"))
  @ManyToMany
  Songs[] song;
}
