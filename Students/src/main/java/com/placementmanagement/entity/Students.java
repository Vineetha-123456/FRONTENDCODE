package com.placementmanagement.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;


@Entity
@Table(name="students")
public class Students 
{

	    @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
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

================================================

.main-container {
    font-family: Arial, sans-serif;
    padding: 20px;
    background-color: #f7f7f7;
  }
  
  /* Welcome section */
  .welcome-section {
    background-color: #007BFF;
    color: white;
    padding: 20px;
    border-radius: 8px;
    text-align: center;
  }
  
  .welcome-section h1 {
    margin: 0;
    font-size: 2.5em;
  }
  
  .welcome-section p {
    font-size: 1.2em;
  }
  
  /* Student details section */
  .student-details {
    background-color: #fff;
    padding: 20px;
    margin-top: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
  .student-details h2 {
    color: #333;
  }
  
  .student-details p {
    font-size: 1.1em;
  }
  
  .student-details strong {
    font-weight: bold;
  }
  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
h3{
    margin-left: 6rem;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
h1{
    margin-top: -2%;
    margin-left: 45%;
}
/* .vp-img{
    height: 10rem;
    width: 10rem;
    border: 4px solid black;
    border-radius: 50%;
    margin-left: 6rem;
    
} */
.f{
    margin-top: 5%;
}
.student-profile{
    display: flex;
    flex-direction: column;
    background:linear-gradient(180deg, rgba(203, 237, 171, 0.984) 30.34%, #c3c970 55.94%);
    min-height: max-content;
    border-radius: 2rem;
    width: 100%;
    padding: 4rem;
    margin-top: 3%;
    margin-left: -10%;
}
.stud-pic1{
    margin-left: 0.9rem;
    margin-top: 0.9rem;
    box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
p{
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    font-weight: 600;
    margin-top: 2rem;
}
.upd{
    margin-top: 2.5%;
    margin-left: 45%;
    border-radius: 2rem;
    padding: 2%;
    width:15%;
    height: 10%;
    color: black;
    font-weight: 500;
}

----------------------------------------
/* Styling for the entire announcements section */
.ann-main {
    display: flex;
    flex-direction: column;
    background: linear-gradient(45deg, #8EDACA 30.34%, #aeebde 55.94%);
    min-height: max-content;
    border-radius: 2rem;
    width: 100%;
    padding: 5rem; /* Increased padding for a bigger box */
    margin-top: 3%;
    margin-left: -10%;
  }
  
  /* Styling for the form section */
  .aff {
    display: flex;
    flex-direction: row;
    margin-top: 2rem;
    margin-left: 2rem;
    justify-content: space-around;
  }
  
  /* Styling for the form container */
  .aform-main {
    display: flex;
    flex-direction: column;
    padding: 2rem;
    justify-content: space-around;
    align-items: center;
  }
  
  /* Styling for form input fields */
  .int1, .int2 {
    width: 100%;
    padding: 10px;
    border-radius: 8px;
    border: 1px solid #ccc;
    font-size: 1rem;
    margin-top: 10px;
    margin-bottom: 15px;
  }
  
  /* Styling for text area field */
  .int2 {
    resize: vertical;
    height: 150px;
  }
  
  /* Styling for each announcement */
  .announce-main {
    display: flex;
    flex-direction: column;
    margin-top: 5%;
    background: linear-gradient(45deg, #8EDACA 30.34%, #aeebde 55.94%);
    min-height: max-content;
    border-radius: 2rem;
    margin-left: -10%;
    width: 100%;
    padding: 4rem;
  }
  
  /* Styling for the list of announcements */
  .ul {
    display: flex;
    flex-direction: column;
    margin-top: 2%;
  }
  
  /* Styling for each announcement item */
  .li {
    display: flex;
    flex-direction: column;
    background: linear-gradient(45deg, #d8d8d8 30.34%, #dcdcdc 55.94%);
    min-height: max-content;
    border-radius: 2rem;
    padding: 20px;
    margin-bottom: 20px;
  }
  
  /* Styling for announcement title */
  h3 {
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    font-weight: 600;
    font-size: larger;
    margin-bottom: 10px;
  }
  
  /* Styling for input labels */
  .ek {
    font-weight: bold;
    margin-bottom: 10px;
  }
  
  /* Button styling */
  .btn-ann {
    background-color: #4CAF50;
    color: white;
    padding: 12px 24px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1rem;
  }
  
  .btn-ann:hover {
    background-color: #45a049;
  }
  
  /* Minor adjustments */
  .ek1 {
    margin-top: 15px;
  }
 