package com.emberlights.offthecharts.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "playlists")
public class playlists {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistID;

    @Column (name = "playlistName", nullable = false, length = 50)
    private String playlistName;

    @Column (name = "creationTime", nullable = false)
    @CreationTimestamp(source = SourceType.DB)
    Instant creationTime;

    @Column (name = "numberSongs", nullable = false)
    private int numberSongs;

    @JoinColumn(name = "albumID", nullable = false)
    @ManyToOne
    albums album;

    @JoinTable(name = "playlist_songs", joinColumns = 
        @JoinColumn (name = "playlistID", referencedColumnName = "playlistID"),
        inverseJoinColumns = @JoinColumn (name = "songID", referencedColumnName = "songID"))
    songs[] song;

}
