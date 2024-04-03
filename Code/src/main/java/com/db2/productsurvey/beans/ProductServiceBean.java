package com.db2.productsurvey.beans;

import com.db2.productsurvey.entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name = "ProductServiceBean")
public class ProductServiceBean {
    @PersistenceContext(unitName = "ProductSurvey")
    private EntityManager em;
    public ProductServiceBean() {
    }
    public Product createProduct(String name, byte[] picture) {
        Product product=new Product();
        product.setName(name);
        product.setPicture(picture);
        em.persist(product);
        return product;
    }
    public List<Product> getProducts() {
        return em.createNamedQuery("Product.getAll", Product.class).getResultList();
    }

    public void deleteProduct(int id) {
        Product product=em.find(Product.class, id);
        em.remove(product);
    }
}