package com.emberlights.offthecharts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "albums")
public class albums {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumID;

    @Column (name = "albumName", nullable = false, length = 100)
    private String albumName;

    @Column (name = "artistName", nullable = false, length = 60)
    private String artistName;

    
}
