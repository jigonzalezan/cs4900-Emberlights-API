package com.emberlights.offthecharts.model;

import com.emberlights.offthecharts.model.*;
import java.time.LocalTime;

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
@Table(name = "songs")
public class songs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songID;

    @Column (name = "songName", nullable = false, length = 100)
    private String songName;

    @Column (name = "songDuration", nullable = false)
    LocalTime songDuration;

    @Column (name = "numberSongs", nullable = false)
    private int numberSongs;

    @JoinColumn(name = "albumID", nullable = false)
    @ManyToOne 
    genres genre;

    @JoinColumn(name = "genreID", nullable = false)
    @ManyToOne
    albums album;
    
    @ManyToMany (mappedBy = "song")
    playlists[] playlist;
}
