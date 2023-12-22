package com.news.News.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for representing news information in GET requests.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class NewsDto {

    private Long id;

    private String title;

    private String body;

    private LocalDate date;

    private String image; // Image represented as a URL in NewsDto

}
