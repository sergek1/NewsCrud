package com.news.News.repository;

import com.news.News.model.entities.News;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing News entities.
 */
@Repository
public interface NewsRepository extends BaseRepository<News, Long> {
}
