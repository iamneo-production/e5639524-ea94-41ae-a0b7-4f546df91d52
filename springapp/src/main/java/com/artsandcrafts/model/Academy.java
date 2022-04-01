package com.artsandcrafts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Academy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int academyId;
	private String academyName;
	private String academyDescription;
	private String academyLocation;
	private String academyMobileNo;
	private String academyEmail;
	private String academyImageUrl;
	private double rating;
	
	public Academy() {

	}
	public Academy(int academyId, String academyName, String academyDescription, String academyLocation,
			String academyMobileNo, String academyEmail, String academyImageUrl) {
		super();
		this.academyId = academyId;
		this.academyName = academyName;
		this.academyDescription = academyDescription;
		this.academyLocation = academyLocation;
		this.academyMobileNo = academyMobileNo;
		this.academyEmail = academyEmail;
		this.academyImageUrl = academyImageUrl;
	}
	public String getAcademyLocation() {
		return academyLocation;
	}
	public void setAcademyLocation(String academyLocation) {
		this.academyLocation = academyLocation;
	}
	public String getAcademyImageUrl() {
		return academyImageUrl;
	}
	public void setAcademyImageUrl(String academyImageUrl) {
		this.academyImageUrl = academyImageUrl;
	}
	public int getAcademyId() {
		return academyId;
	}
	public void setAcademyId(int academyId) {
		this.academyId = academyId;
	}
	public String getAcademyName() {
		return academyName;
	}
	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
	public String getAcademyDescription() {
		return academyDescription;
	}
	public void setAcademyDescription(String academyDescription) {
		this.academyDescription = academyDescription;
	}
	public String getAcademyMobileNo() {
		return academyMobileNo;
	}
	public void setAcademyMobileNo(String academyMobileNo) {
		this.academyMobileNo = academyMobileNo;
	}
	public String getAcademyEmail() {
		return academyEmail;
	}
	public void setAcademyEmail(String academyEmail) {
		this.academyEmail = academyEmail;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
