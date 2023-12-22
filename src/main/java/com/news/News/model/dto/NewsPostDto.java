package com.news.News.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for handling news information in POST requests.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class NewsPostDto {

    private Long id;

    private String title;

    private String body;

    private LocalDate date;

    private MultipartFile image; // Image represented as a MultipartFile in NewsPostDto

}