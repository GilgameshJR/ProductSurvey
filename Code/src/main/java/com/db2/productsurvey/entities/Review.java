package com.db2.productsurvey.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes =
@Index(name = "review_index", columnList = "TIMESTAMP")
)
public class Review {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    private String review;

    @Column(name = "TIMESTAMP", nullable = false)
    Date timestamp;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }


    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
}