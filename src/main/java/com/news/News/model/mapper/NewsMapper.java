package com.news.News.model.mapper;

import com.news.News.model.dto.NewsDto;
import com.news.News.model.dto.NewsPostDto;
import com.news.News.model.entities.News;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for converting between different representations of news entities, such as News, NewsDto and NewsPostDto.
 */
public class NewsMapper {

    /**
     * Converts a News entity to a NewsDto.
     *
     * @param news The News entity to be converted.
     * @return The corresponding NewsDto.
     */
    public static NewsDto newsToNewsDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setBody(news.getBody());
        newsDto.setDate(news.getDate());
        newsDto.setImage(mapImage(news.getImage()));
        return newsDto;
    }

    /**
     * Converts a NewsDto to a News entity.
     *
     * @param newsDto The NewsDto to be converted.
     * @return The corresponding News entity.
     */
    public static News newsDtoToNews(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setBody(newsDto.getBody());
        news.setDate(newsDto.getDate());
        news.setImage(mapImage(newsDto.getImage()));
        return news;
    }

    /**
     * Converts a NewsPostDto to a News entity.
     *
     * @param newsPostDto The NewsPostDto to be converted.
     * @return The corresponding News entity.
     */
    public static News newsPostDtoToNews(NewsPostDto newsPostDto) {
        News news = new News();
        news.setId(newsPostDto.getId());
        news.setTitle(newsPostDto.getTitle());
        news.setBody(newsPostDto.getBody());
        news.setDate(newsPostDto.getDate());
        news.setImage(mapPostImage(newsPostDto.getImage()));
        return news;
    }

    /**
     * Maps a multipart file representing an image to a byte array.
     *
     * @param imageMultipartFile The image in the form of a multipart file.
     * @return The byte array representation of the image.
     */
    private static byte[] mapPostImage(MultipartFile imageMultipartFile) {
        try {
            if (imageMultipartFile != null) {
                return imageMultipartFile.getBytes();
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    /**
     * Maps a byte array representing an image to a base64-encoded string.
     *
     * @param imageBytes The byte array representing the image.
     * @return The base64-encoded string representation of the image.
     */
    private static String mapImage(byte[] imageBytes) {
        if (imageBytes != null) {
            String base64Encoded = new String(Base64.getEncoder().encode(imageBytes), StandardCharsets.UTF_8);
            String encoderImg = String.format("data:image/png;base64,%s", base64Encoded);
            return encoderImg;
        }
        return null;
    }

    /**
     * Maps a base64-encoded string representing an image to a byte array.
     *
     * @param base64Image The base64-encoded string representation of the image.
     * @return The byte array representation of the image.
     */
    private static byte[] mapImage(String base64Image) {
        if (base64Image != null) {
            return Base64.getDecoder().decode(base64Image);
        }
        return null;
    }

    /**
     * Converts a list of News to a list of NewsDto.
     *
     * @param newsList The list of News to be converted.
     * @return The corresponding list of NewsDto.
     */
    public static List<NewsDto> newsListToNewsDtoList(List<News> newsList) {
        return newsList.stream()
                .map(NewsMapper::newsToNewsDto)
                .collect(Collectors.toList());
    }

    /**
     * Converts a list of NewsDto to a list of News entities.
     *
     * @param newsDtoList The list of NewsDto to be converted.
     * @return The corresponding list of News entities.
     */
    public static List<News> newsDtoListToNewsList(List<NewsDto> newsDtoList) {
        return newsDtoList.stream()
                .map(NewsMapper::newsDtoToNews)
                .collect(Collectors.toList());
    }
}
