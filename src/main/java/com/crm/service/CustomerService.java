package com.crm.service;
import com.crm.entity.Customer;
import com.crm.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerService {

    public void registerCustomer(String name, String email, String phone) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer c = new Customer();
            c.setName(name);
            c.setEmail(email);
            c.setPhone(phone);

            em.persist(c);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
