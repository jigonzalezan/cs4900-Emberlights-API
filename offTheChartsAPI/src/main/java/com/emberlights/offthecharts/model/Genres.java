package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Genres {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "genreID", nullable = false)
  int genreID;

  @Column(name = "genreName", length = 50, nullable = false)
  String genreName;
}
