/**
 * 
 */
package com.hibernate.training.HelloWorld.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author_profile_tbl")
public class AuthorProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_profile_id")
	private Long authorProfileId;
	@Column(name = "home_addr", unique = true, nullable = false)
	private String homeAddress;
	@Column(name = "office_addr", unique = true, nullable = false)
	private String officeAddress;
	@Column(name = "university", unique = true, nullable = false)
	private String university;
	@Column(name = "phone_number", unique = true, nullable = false)
	private String phoneNumber;

	public Long getAuthorProfileId() {
		return authorProfileId;
	}

	public void setAuthorProfileId(Long authorProfileId) {
		this.authorProfileId = authorProfileId;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
