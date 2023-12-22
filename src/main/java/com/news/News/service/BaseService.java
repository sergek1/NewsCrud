package com.news.News.service;

import com.news.News.model.entities.BaseEntity;
import com.news.News.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Abstract base service providing common operations for entities extending BaseEntity.
 *
 * @param <E> The entity type.
 * @param <V> The type of the entity's identifier.
 * <p>
 * Annotations:
 * - @Service: Indicates that the class is a Spring service component, allowing it to be automatically discovered and instantiated by Spring.
 * - @RequiredArgsConstructor: Lombok annotation to generate a constructor with required arguments, injecting the BaseRepository dependency.
 */
@Service
@RequiredArgsConstructor
public abstract class BaseService<E extends BaseEntity<V>, V> {
    private final BaseRepository<E, V> baseRepository;

    /**
     * Adds a new entity to the repository.
     *
     * @param entity The entity to be added.
     */
    public void add(E entity) {
        baseRepository.save(entity);
    }

    /**
     * Retrieves all entities from the repository.
     *
     * @return A list of all entities.
     */
    public List<E> getAll() {
        return baseRepository.findAll();
    }

    /**
     * Deletes an entity by its identifier.
     *
     * @param id The identifier of the entity to be deleted.
     */
    public void deleteById(V id) {
        baseRepository.deleteById(id);
    }

    /**
     * Finds an entity by its identifier.
     *
     * @param id The identifier of the entity to be found.
     * @return The found entity or null if not found.
     */
    public E findById(V id) {
        return baseRepository.findById(id).orElse(null);
    }

}
