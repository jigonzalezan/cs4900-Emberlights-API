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
@Table(name = "genres")
public class genres {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreID;

    @Column (name = "genreName", nullable = false, length = 50)
    private String genreName;
    
}
