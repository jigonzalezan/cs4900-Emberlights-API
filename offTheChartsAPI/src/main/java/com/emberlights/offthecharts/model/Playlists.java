package com.emberlights.offthecharts.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Playlists")
public class Playlists
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlistID", nullable = false)
    Integer playlistID;

    @Column(name = "playlistName", length = 50, nullable = false)
    String playlistName;

    @Column(name = "creationTime", nullable = false)
    LocalDateTime creationTime;

    @Column(name = "numberSongs", nullable = false)
    Integer numberSongs;

    @ManyToOne
    @JoinColumn(name = "genreID", nullable = false, referencedColumnName = "genreID")
    Genres genres;

    @ManyToMany(mappedBy = "playlist")
    List<Songs> songs;
}