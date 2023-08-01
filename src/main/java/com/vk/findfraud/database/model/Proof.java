package com.vk.findfraud.database.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proof {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long proof_id;

	@Column(nullable = false)
	String path, description;

	@ManyToOne
	Fraud fraud;

	Date createdDate, modifiedDate;

	public long getProof_id() {
		return proof_id;
	}

	public void setProof_id(long proof_id) {
		this.proof_id = proof_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Fraud getFraud() {
		return fraud;
	}

	public void setFraud(Fraud fraud) {
		this.fraud = fraud;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
