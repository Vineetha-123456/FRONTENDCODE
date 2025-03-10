package com.placementmanagement.service;
 
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.placementmanagement.entity.Job;
import com.placementmanagement.exception.JobServiceException;
import com.placementmanagement.repo.JobRepository;
 
import jakarta.transaction.Transactional;
 
@Service 
@Transactional 
public class JobService  
{
 
  @Autowired 
  private JobRepository repo;
  private static final Logger logger=LoggerFactory.getLogger(JobService.class);

  public void save(Job certificate)  
  { 
      repo.save(certificate); 
  }
 
  public List<Job> getAllJobs() {
	    try {
	        List<Job> jobs = repo.findAll();
	        if (jobs.isEmpty()) {
	            throw new JobServiceException("No jobs found.");
	        }
	        logger.info("Retrieved all jobs successfully.");
	        return jobs;
	    } catch (JobServiceException ex) {
	        logger.warn("JobServiceException occurred while fetching all jobs", ex.getMessage());
	        throw ex;
	    } catch (Exception ex) {
	        logger.error("An unexpected error occurred while retrieving all jobs", ex);
	        throw new JobServiceException("An error occurred while retrieving the jobs.", ex);
	    }
	}
 
 
  public Job postJob(Job job) {
	    try {
	        if (job == null) {
	            throw new JobServiceException("Job cannot be null.");
	        }
	        Job savedJob = repo.save(job);
	        logger.info("Job posted successfully with ID: " + savedJob.getJobId());
	        return savedJob;
	    } catch (JobServiceException ex) {
	        logger.warn("JobServiceException occurred while posting the job", ex.getMessage());
	        throw ex;
	    } catch (Exception ex) {
	        logger.error("An unexpected error occurred while posting the job", ex);
	        throw new JobServiceException("An error occurred while posting the job.", ex);
	    }
	}
  

 
 
  public Job getJobById(Long jobId) {
	    try {
	        if (jobId == null) {
	            throw new JobServiceException("Job ID cannot be null.");
	        }
	        Job job = repo.findById(jobId)
	                .orElseThrow(() -> new JobServiceException("Job not found with ID: " + jobId));
	        logger.info("Retrieved Job with ID: " + job.getJobId());
	        return job;
	    } catch (JobServiceException ex) {
	        logger.warn("JobServiceException occurred while retrieving job by ID", ex.getMessage());
	        throw ex;
	    } catch (Exception ex) {
	        logger.error("An unexpected error occurred while retrieving job by ID", ex);
	        throw new JobServiceException("An error occurred while retrieving the job by ID.", ex);
	    }
	}
 

} 
