package com.hibernate.training.HelloWorld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="print_company_tbl")
public class PrintingCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id")
	private Long companyID;
	@Column(name="company_name",unique = true,nullable = false)
	private String CompanyName;

	
	
	public Long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	
	
}
