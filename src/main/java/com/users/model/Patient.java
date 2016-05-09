package com.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "patient", catalog = "hospital")
public class Patient {

	@Id
	@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 45)
	private int id;

	private String firstName;
	private String lastName;
	private String cnp;
	private String address;
	private String dateOfBirth;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Consultation> acc = new ArrayList<Consultation>();

	// @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	// @LazyCollection(LazyCollectionOption.FALSE)
	// private List<Bills> bill=new ArrayList<Bills>();
	//
	public Patient() {

	}

	public Patient(int id, String firstName, String lastName, String address) {

		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}

	@Column(name = "firstName", nullable = false, length = 60)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 60)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "cnp", nullable = false, length = 60)
	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	@Column(name = "address", nullable = false, length = 60)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Consultation> getAcc() {
		return acc;
	}

	public void setAcc(List<Consultation> acc) {
		this.acc = acc;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
