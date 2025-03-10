package com.placementmanagement.controller;
 
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
 
import com.placementmanagement.entity.Announcement;
import com.placementmanagement.exception.AnnouncementServiceException;
import com.placementmanagement.service.AnnouncementService;
 
@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController 
{
	@Autowired
	private AnnouncementService service;
    @GetMapping("/announcements")
    public ResponseEntity<List<Announcement>> getAllAnnouncements() 
    {
        try {
            List<Announcement> announcements = service.getAllAnnouncements();
            if (announcements.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(announcements);
            }
            return ResponseEntity.ok(announcements);
        } catch (AnnouncementServiceException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    
    @PostMapping
    public ResponseEntity<String> postAnnouncement(@RequestBody Announcement announcement) {
        try {
            if (announcement == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Announcement cannot be null.");
            }
            service.postAnnouncement1(announcement);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Announcement posted successfully.");
        } catch (AnnouncementServiceException ex) {
            // Log the exception for debugging
            ex.printStackTrace();  // This will log the stack trace in your application logs
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Failed to post the announcement: " + ex.getMessage());
        } catch (Exception ex) {
            // Log the exception for debugging
            ex.printStackTrace();  // Log unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred while posting the announcement: " + ex.getMessage());
        }
    }


    }


