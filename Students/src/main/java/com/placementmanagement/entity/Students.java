package com.placementmanagement.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;


@Entity
@Table(name="students")
public class Students 
{

	    @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	    private Long id;
	    private String status; // "placed" or "unplaced"
		private String username;
	    private String email;
	    private String password;
	    @Column(name="contact_no")
	    private String contactNo;
	    private String batch;
	    private String skills;
	    private Float cgpa;
	    private String stream;
	    @Column(name="roll_no")
	    private String rollNo;
	    private String name;
	    
	    
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	    public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Students()
	    {
	    	
	    }
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getRollNo() {
			return rollNo;
		}
		public void setRollNo(String rollNo) {
			this.rollNo = rollNo;
		}
		public String getContactNo() {
			return contactNo;
		}
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}
		public String getBatch() {
			return batch;
		}
		public void setBatch(String batch) {
			this.batch = batch;
		}
		
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		public Float getCgpa() {
			return cgpa;
		}
		public void setCgpa(Float cgpa) {
			this.cgpa = cgpa;
		}
		public String getStream() {
			return stream;
		}
		public void setStream(String stream) {
			this.stream = stream;
		}
		
		public Students(Long id,String username, String email, String password, String rollNo, String contactNo, String batch,
				String skills, Float cgpa, String stream,String status,String name) {
			super();
			this.id=id;
			this.username = username;
			this.email = email;
			this.password = password;
			this.contactNo = contactNo;
			this.batch = batch;
			this.skills = skills;
			this.cgpa = cgpa;
			this.stream = stream;
			this.name=name;
			this.rollNo=rollNo;
			this.status=status;
			
		}
		@Override
		public String toString() {
			return "Students [id=" + id + ", status=" + status + ", username=" + username + ", email=" + email
					+ ", password=" + password + ", contactNo=" + contactNo + ", batch=" + batch + ", skills=" + skills
					+ ", cgpa=" + cgpa + ", stream=" + stream + ", rollNo=" + rollNo + ", name=" + name + "]";
		}
		
		
	}

 
