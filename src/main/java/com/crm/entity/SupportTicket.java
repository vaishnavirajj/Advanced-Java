package com.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue
    private Long id;

    private String issueDescription;
    

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIssueDescription() {
		return issueDescription;
	}


	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	@OneToOne
    private Order order;
}