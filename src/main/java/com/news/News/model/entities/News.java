package com.news.News.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entity class representing news posts.
 * <p>
 * Annotations:
 * - @Entity: Indicates that the class is an entity, allowing it to be mapped to a database table.
 * - @Table(name = "news"): Specifies the name of the table in the database.
 * - @Data: Lombok annotation to automatically generate getters, setters, toString(), and other boilerplate code.
 * - @NoArgsConstructor: Lombok annotation to generate a no-argument constructor.
 * - @EqualsAndHashCode(callSuper = false): Lombok annotation to generate equals and hashCode methods excluding the superclass.
 */
@Entity
@Table(name = "news")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class News extends BaseEntity<Long> {

    /**
     * Unique identifier for a news.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title of the news.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * Body/content of the news.
     */
    @Column(name = "body", nullable = false, columnDefinition = "text")
    private String body;

    /**
     * Date when the news was created.
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * Image associated with the news, stored as a byte array.
     */
    @Lob
    private byte[] image;

    /**
     * Constructor for creating a News object with specified attributes.
     *
     * @param title Title of the news.
     * @param body  Body/content of the news.
     * @param date  Date when the news was created.
     * @param image Image associated with the news.
     */
    public News(String title, String body, LocalDate date, byte[] image) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.image = image;
    }
}
