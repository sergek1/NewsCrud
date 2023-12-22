package com.news.News.service;

import com.news.News.model.dto.NewsDto;
import com.news.News.model.entities.News;
import com.news.News.model.mapper.NewsMapper;
import com.news.News.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing News entities.
 * <p>
 * Annotations:
 * - @Service: Indicates that the class is a Spring service component, allowing it to be automatically discovered and instantiated by Spring.
 * - @Autowired: Annotation for automatic dependency injection of the NewsRepository.
 */
@Service
public class NewsService extends BaseService<News, Long> {

    NewsRepository repository;

    @Autowired
    public NewsService(NewsRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Retrieves a sublist of news entities based on page size and current page.
     *
     * @param pageSize    The number of news entities to be displayed on one page.
     * @param currentPage The current page number.
     * @return A sublist of news entities for the specified page.
     */
    public List<News> getNewsForPage(int pageSize, int currentPage) {
        int totalPages = getPagesCount(pageSize);
        int startIndex = 0;
        int endIndex = 0;
        if (getNewsCount() > 0) {
            int newsForPage = (currentPage != totalPages) ? pageSize : getNewsCount() - (currentPage - 1) * pageSize;
            startIndex = (currentPage - 1) * pageSize;
            endIndex = (currentPage - 1) * pageSize + newsForPage;
        }
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id")).subList(startIndex, endIndex);
    }

    /**
     * Retrieves the total count of news entities.
     *
     * @return The total count of news entities.
     */
    public int getNewsCount() {
        return repository.findAll().size();
    }

    /**
     * Calculates the total number of pages based on page size.
     *
     * @param pageSize The number of news entities to be displayed on one page.
     * @return The total number of pages.
     */
    public int getPagesCount(int pageSize) {
        int totalNewsCount = getNewsCount();
        return (int) Math.ceil((double) totalNewsCount / pageSize);
    }

    /**
     * Retrieves a list of NewsDto for the specified page.
     *
     * @param pageSize    The number of news entities to be displayed on one page.
     * @param currentPage The current page number.
     * @return A list of NewsDto for the specified page.
     */
    public List<NewsDto> getNewsDtos(int pageSize, int currentPage) {
        List<News> newsSublist = getNewsForPage(pageSize, currentPage);
        return NewsMapper.newsListToNewsDtoList(newsSublist);
    }

    /**
     * Finds a NewsDto by its identifier.
     *
     * @param id The identifier of the news entity.
     * @return The corresponding NewsDto or null if not found.
     */
    public NewsDto findNewsDtoById(Long id) {
        News news = findById(id);
        return NewsMapper.newsToNewsDto(news);
    }
}
