package com.news.News.repository;

import com.news.News.model.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base repository interface for entities extending BaseEntity.
 * By extending JpaRepository, the BaseRepository inherits a set of predefined methods for interacting with the database.
 * These methods include basic CRUD operations, making it easier to perform standard database operations without
 * the need for explicit implementation in each repository interface.
 *
 * @param <E> The entity type.
 * @param <V> The type of the entity's identifier.
 *
 * Annotations:
 * - @NoRepositoryBean :the interface should not be instantiated directly.
 */
@NoRepositoryBean

public interface BaseRepository<E extends BaseEntity<V>, V> extends JpaRepository<E, V> {
}
