package com.emberlights.offthecharts.model;

import java.time.LocalTime;
import java.util.List;

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
import lombok.Data;

@Data
@Entity
@Table(name = "Songs")
public class Songs
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songID", nullable = false)
    Integer songID;

    @Column(name = "songName", length = 100, nullable = false)
    String songName;

    @Column(name = "songDuration", nullable = false)
    LocalTime songDuration;

    @ManyToOne 
    @JoinColumn(name = "genreId", nullable = false, referencedColumnName = "genreID")
    Genres genres;

    @ManyToOne 
    @JoinColumn(name = "albumId", nullable = false, referencedColumnName = "albumID")
    Albums albums;

    @ManyToMany 
    @JoinTable 
    (
        name = "PlaylistSongs",
        joinColumns = @JoinColumn(name = "songId", referencedColumnName = "songID"),
        inverseJoinColumns = @JoinColumn(name = "playlistId", referencedColumnName = "playlistID")
    )
    List<Playlists> playlist;}