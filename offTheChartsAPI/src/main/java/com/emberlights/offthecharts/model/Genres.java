package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Genres")
public class Genres {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "genreID", nullable = false)
  Integer genreID;

  @Column(name = "genreName", length = 50, nullable = false)
  String genreName;
}
