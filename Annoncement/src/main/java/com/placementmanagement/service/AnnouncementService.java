package com.placementmanagement.service;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.placementmanagement.entity.Announcement;
import com.placementmanagement.exception.AnnouncementServiceException;
import com.placementmanagement.repository.AnnouncementRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import jakarta.transaction.Transactional;
 
@Service
@Transactional
 
public class AnnouncementService 
{
	 @Autowired
	 private AnnouncementRepository repo;
	 Logger logger=LoggerFactory.getLogger(AnnouncementService.class);
	 public void save(Announcement placement) 
	 {
	 repo.save(placement);
	 }
	 public void postAnnouncement1(Announcement anc)
	 { 
	   try
	   { 
		   if (anc == null) 
		   { 
			   logger.error("No Announcement");
			   throw new AnnouncementServiceException("Announcement record is null.");
		   } 
		   // Add placement record to database 
		   repo.save(anc); 
		   logger.info("Placement record added successfully:",anc);
		   } 
	   catch (AnnouncementServiceException ex) 
	   { 
		   // Rethrow the exception to be handled by GlobalExceptionHandler
		   logger.warn("AnnouncementServiceException occured",ex.getMessage());
		   throw ex; 
		   } 
	   catch (Exception ex) 
	   {
		   // Catching unexpected exceptions
		      logger.error("An unexpected error occured while posting announcement record.",ex);
			   throw new AnnouncementServiceException("An error occurred while posting announcement.", ex); 
			   }
	   }
 
	    public List<Announcement> getAllAnnouncements() 
	    {
	        return repo.findAll();
	    }
 
	   
	}