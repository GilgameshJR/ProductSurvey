package com.db2.productsurvey.entities;

import javax.persistence.*;
import java.util.Base64;
import java.util.List;

@NamedQuery(name="Product.getAll",
    query="SELECT p FROM Product p")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Basic(fetch = FetchType.EAGER)
    @Lob
    private byte[] picture;

    public String getPicture() {
        return Base64.getMimeEncoder().encodeToString(picture);
    }

    @OneToMany (mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Questionnaire> questionnaires;

    @OneToMany (mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("timestamp DESC")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}