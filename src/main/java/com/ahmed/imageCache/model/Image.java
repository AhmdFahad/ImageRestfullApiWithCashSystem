package com.ahmed.imageCache.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;

@Entity
@Table(name = "image")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "image_data", nullable = false)
    private Blob imageData;
}