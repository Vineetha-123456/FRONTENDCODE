package com.placementmanagement.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;

 
import com.placementmanagement.entity.Job; 
public interface JobRepository extends JpaRepository<Job, Long>  
{ 

	
}
