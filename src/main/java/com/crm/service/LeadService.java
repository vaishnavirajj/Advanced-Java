package com.crm.service;

import com.crm.entity.Lead;
import com.crm.entity.SalesEmployee;
import com.crm.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LeadService {

    // create lead
    public void createLead(String name, String source, String contactInfo) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead = new Lead();
            lead.setName(name);
            lead.setSource(source);
            lead.setContactInfo(contactInfo);

            em.persist(lead);

            tx.commit();
            System.out.println("✅ Lead created");

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    // assign lead to employee
    public void assignLeadToEmployee(Long leadId, Long empId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee emp = em.find(SalesEmployee.class, empId);

            lead.setEmployee(emp);

            tx.commit();
            System.out.println("✅ Lead assigned");

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}