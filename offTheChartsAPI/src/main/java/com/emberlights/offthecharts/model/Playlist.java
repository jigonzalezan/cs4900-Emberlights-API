package com.emberlights.offthecharts.model;

import java.time.LocalDateTime;
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
@Table(name = "Playlist")
public class Playlist
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "albumID", nullable = false)
    Integer albumID;

    @Column(name = "playlistName", length = 50, nullable = false)
    String playlistName;

    @Column(name = "creationTime", nullable = false)
    LocalDateTime creationTime;

    @Column(name = "numberSongs", nullable = false)
    Integer numberSongs;

    @ManyToOne
    @JoinColumn(name = "genreID", nullable = false)
    Genres genre;

    @ManyToMany(mappedBy = "playlist")
    Songs[] songs;
}