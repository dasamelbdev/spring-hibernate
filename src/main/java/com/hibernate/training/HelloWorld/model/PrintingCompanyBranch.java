package com.hibernate.training.HelloWorld.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prining_branch_tbl")
public class PrintingCompanyBranch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="branch_id")
	private Long printingCompanyBranchId;
	@Column(name="branch_name",unique = false,nullable = false)
	private String branchName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private PrintingCompany printingCompany;
	
	

	public PrintingCompany getPrintingCompany() {
		return printingCompany;
	}
	public void setPrintingCompany(PrintingCompany printingCompany) {
		this.printingCompany = printingCompany;
	}
	public Long getPrintingCompanyBranchId() {
		return printingCompanyBranchId;
	}
	public void setPrintingCompanyBranchId(Long printingCompanyBranchId) {
		this.printingCompanyBranchId = printingCompanyBranchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	

}
