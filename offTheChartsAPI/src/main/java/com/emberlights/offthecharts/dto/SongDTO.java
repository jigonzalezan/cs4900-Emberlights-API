package com.emberlights.offthecharts.dto;

public record SongDTO(
    Integer songID, String songName, String songDuration, Integer genreID, Integer albumID) {}
