package com.placementmanagement.controller;
import com.placementmanagement.entity.Job;
import com.placementmanagement.exception.JobServiceException;
import com.placementmanagement.service.JobService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/jobs")  
public class JobController {
 
    @Autowired
    private JobService jobService;
 
    
    @GetMapping("/Alljobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        try {
            List<Job> jobs = jobService.getAllJobs();
            return new ResponseEntity<>(jobs, HttpStatus.OK);  // Return 200 OK with the list of jobs
        } catch (JobServiceException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Return 404 if no jobs found
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 for unexpected errors
        }
    }
 
    
    @PostMapping("/jobs")
    public ResponseEntity<Job> postJob(@RequestBody Job job) {
        try {
            Job savedJob = jobService.postJob(job);
            return new ResponseEntity<>(savedJob, HttpStatus.CREATED);  // Return 201 Created with the saved job
        } catch (JobServiceException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);  // Return 400 for bad request if job is invalid
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 for unexpected errors
        }
    }
 
   
    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        try {
            Job job = jobService.getJobById(jobId);
            return new ResponseEntity<>(job, HttpStatus.OK);  // Return 200 OK with the job
        } catch (JobServiceException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Return 404 if job is not found
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 for unexpected errors
        }
    }
}
