package com.emberlights.offthecharts.repository;

import com.emberlights.offthecharts.dto.SongRequestDto;
import com.emberlights.offthecharts.model.Songs;
import org.springframework.data.jpa.domain.Specification;

public class SongSpecifications {
  public static Specification<Songs> withCriteria(SongRequestDto criteria) {
    return (root, query, criteriaBuilder) -> {
      var predicates = criteriaBuilder.conjunction();

      if (criteria.getSongName() != null && !criteria.getSongName().isBlank()) {
        predicates = criteriaBuilder.and(
            predicates,
            criteriaBuilder.like(
                criteriaBuilder.lower(root.get("songName")),
                "%" + criteria.getSongName().toLowerCase() + "%"));
      }

      if (criteria.getGenreID() != null) {
        predicates = criteriaBuilder.and(
            predicates,
            criteriaBuilder.equal(root.get("genre").get("genreID"), criteria.getGenreID()));
      }

      if (criteria.getAlbumID() != null) {
        predicates = criteriaBuilder.and(
            predicates,
            criteriaBuilder.equal(root.get("album").get("albumID"), criteria.getAlbumID()));
      }

      if (criteria.getSongDuration() != null) {
        predicates = criteriaBuilder.and(
            predicates,
            criteriaBuilder.equal(root.get("songDuration"), criteria.getSongDuration()));
      }

      return predicates;
    };
  }
}
