package com.placementmanagement.entity;
import java.sql.Date;
 
//package com.tns.sf05;
 
import jakarta.persistence.*;
 
@Entity
@Table(name="announcement")
public class Announcement 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String title;
    private String description;
    @Column(name="last_date_to_apply")
    private Date lastDateToApply;
    private String address;
	public Announcement(Long id, String title, String description, Date lastDateToApply,String address) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.lastDateToApply = lastDateToApply;
		this.address=address;
	}
	public Announcement()
	{
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLastDateToApply() {
		return lastDateToApply;
	}
	public void setLastDateToApply(Date lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Announcement [id=" + id + ", title=" + title + ", description=" + description + ", lastDateToApply="
				+ lastDateToApply + ", address=" + address + "]";
	}
	
 
}
 