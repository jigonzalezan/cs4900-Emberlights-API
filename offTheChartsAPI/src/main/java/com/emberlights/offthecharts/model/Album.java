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
@Table(name = "Albums")
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "albumID", nullable = false)
  private Integer albumID;

  @Column(name = "albumName", length = 100, nullable = false)
  private String albumName;

  @Column(name = "artistName", length = 60, nullable = false)
  private String artistName;

  @OneToMany(mappedBy = "album")
  private List<Song> songs;
}
