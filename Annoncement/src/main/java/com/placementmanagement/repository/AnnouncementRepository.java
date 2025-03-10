package com.placementmanagement.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.placementmanagement.entity.Announcement;
 
 
 
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer>{
		
}