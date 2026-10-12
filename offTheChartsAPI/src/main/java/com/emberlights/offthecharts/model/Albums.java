package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Albums {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "albumID", nullable = false)
  int albumID;

  @Column(name = "albumName", length = 100, nullable = false)
  String albumName;

  @Column(name = "artistName", length = 60, nullable = false)
  String artistName;
}
