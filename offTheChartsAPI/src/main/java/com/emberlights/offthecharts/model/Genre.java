package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Genres")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "genreID", nullable = false)
  private Integer genreID;

  @Column(name = "genreName", length = 50, nullable = false)
  private String genreName;

  @OneToMany(mappedBy = "genre")
  private List<Song> songs;

  @OneToMany(mappedBy = "genre")
  private List<Playlist> playlists;
}
