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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="author_tbl")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
	private Long id;
	@Column(name = "author_fname")
	private String firstName;
	@Column(name = "author_lname")
	private String lastName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profile_id", unique = true, nullable = false)
	private AuthorProfile authorProfile;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public AuthorProfile getAuthorProfile() {
		return authorProfile;
	}
	public void setAuthorProfile(AuthorProfile authorProfile) {
		this.authorProfile = authorProfile;
	}
	
	
	
	
	
}
