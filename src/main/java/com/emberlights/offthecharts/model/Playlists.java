package com.emberlights.offthecharts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "Playlists")
public class Playlists {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "playlistID", nullable = false)
  Integer playlistID;

  @Column(name = "playlistName", length = 50, nullable = false)
  String playlistName;

  @CreationTimestamp
  @Column(name = "creationTime", insertable = false, updatable = false)
  LocalDateTime creationTime;

  @Column(name = "numberSongs", nullable = false)
  Integer numberSongs;

  @ManyToOne
  @JoinColumn(name = "genreID", nullable = false, referencedColumnName = "genreID")
  Genres genres;

  @JsonIgnoreProperties("playlist")
  @ManyToMany(mappedBy = "playlist")
  List<Songs> songs;

  public void addSong(Songs song) {
    this.songs.add(song);
    song.getPlaylist().add(this);
  }
}
