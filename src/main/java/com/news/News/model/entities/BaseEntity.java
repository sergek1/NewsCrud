package com.news.News.model.entities;

/**
 * An abstract class representing a base entity with an identifier.
 * The primary purpose of BaseEntity is to define a common contract for entities.
 *
 * @param <T> Type of the identifier.
 */
public abstract class BaseEntity<T> {

    /**
     * Gets the identifier of the entity.
     *
     * @return The identifier.
     */
    public abstract T getId();

}
