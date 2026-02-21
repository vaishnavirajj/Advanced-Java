package com.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Lead {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String source;
    private String contactInfo;
    

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}


	public SalesEmployee getEmployee() {
		return employee;
	}


	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}


	@ManyToOne
    private SalesEmployee employee;
}