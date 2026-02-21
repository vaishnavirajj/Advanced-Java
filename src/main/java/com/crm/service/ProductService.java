package com.crm.service;

import com.crm.entity.Product;
import com.crm.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductService {

    public void addProduct(String name, double price) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Product p = new Product();
            p.setName(name);
            p.setPrice(price);

            em.persist(p);

            tx.commit();
            System.out.println("✅ Product added successfully");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}