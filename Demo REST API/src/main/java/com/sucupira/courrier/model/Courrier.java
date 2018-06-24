package com.sucupira.courrier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Courrier.
 */
@Entity(name="COURRIERREPO")
public class Courrier {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The full name. */
	@NotBlank
	@Column(name="FULLNAME")
	private String fullName;
	
	/** The email. */
	@NotNull
	@Email
	@Column(name="EMAIL")
	private String email;
	
	/** The deliveries. */
	@NotNull
	@Column(name="DELIVERIES")
	private Integer deliveries;
	
	/** The active. */
	@NotNull
	@Column(name="ACTIVE")
	private boolean active;

	/**
	 * Instantiates a new courrier.
	 *
	 * @param id the id
	 * @param fullName the full name
	 * @param email the email
	 * @param deliveries the deliveries
	 * @param active the active
	 */
	public Courrier(Long id, String fullName, String email, Integer deliveries, boolean active) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.deliveries = deliveries;
		this.active = active;
	}
	
	/**
	 * Instantiates a new courrier.
	 */
	public Courrier() {
		super();
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the deliveries.
	 *
	 * @return the deliveries
	 */
	public Integer getDeliveries() {
		return deliveries;
	}

	/**
	 * Sets the deliveries.
	 *
	 * @param deliveries the new deliveries
	 */
	public void setDeliveries(Integer deliveries) {
		this.deliveries = deliveries;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getFullName()+" - "+getEmail()+". Active: "+isActive()+". Deliveries: "+getDeliveries();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.id.equals(
				((Courrier) obj).getId()) 
				&& this.fullName.equals(((Courrier)obj).getFullName()) 
				&& this.email.equals(((Courrier)obj).getEmail()) 
				&& this.active==((Courrier)obj).isActive() 
				&& this.deliveries == ((Courrier)obj).getDeliveries();
	}
}