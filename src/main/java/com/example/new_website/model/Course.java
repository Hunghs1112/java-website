package com.example.new_website.model;
import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String image_url;
    private double original_price;
    private double discounted_price;

    // Constructors, getters and setters
    public Course() {}

    public Course(String title, String description, String image_url, double original_price, double discounted_price) {
        this.title = title;
        this.description = description;
        this.image_url = image_url;
        this.original_price = original_price;
        this.discounted_price = discounted_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(double discounted_price) {
        this.discounted_price = discounted_price;
    }
}