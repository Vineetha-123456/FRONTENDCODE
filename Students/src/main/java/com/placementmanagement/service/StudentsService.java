package com.placementmanagement.service;
import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import com.placementmanagement.entity.Students;
import com.placementmanagement.exception.StudentsException;
import com.placementmanagement.repo.StudentsRepository;


import jakarta.transaction.Transactional;
@Service
@Transactional
public class StudentsService
{
	 @Autowired 
	  private StudentsRepository repo; 
	 
	 Logger logger=LoggerFactory.getLogger(StudentsService.class);
	 
	
	  public Students registerStudent(Students student) 
	   {
	        
	        return repo.save(student);
	    }

	    public Students loginUser(String username, String password) 
	    {
	        Students student = repo.findByUsername(username);
	        if (student != null && student.getPassword().equals(password))
	        {
	            return student;
	        }
	        return null;
	    }     
	    
//	    public Students getStudentByRollNo(String rollNo) 
//	    {
//	        return repo.get(rollNo);
//	    }
//	    public List<Students> listAll()   
//	    { 
//	        return repo.findAll(); 
//	    } 
	    public List<Students> listAll() {
	        try {
	            List<Students> students = repo.findAll(); // Assuming repo is your repository for accessing students
	            if (students.isEmpty()) {
	                logger.warn("No user records found.");
	            } else {
	                logger.info("Successfully fetched {} user records.", students.size());
	            }
	            return students;
	        } 
	        catch (Exception ex) {
	            logger.error("An unexpected error occurred while fetching the user records.", ex);
	            throw new StudentsException("An error occurred while retrieving the list of students.", ex);
	        }
	    }

	      
	    public void saveStudent(Students student)  
	    { 
	        repo.save(student); 
	    } 
	    
	    
	    
	    public void addStudent(Students student)
	    {
	        try {
	            if (student == null) 
	            {
	                logger.error("User record is null.");
	                throw new StudentsException("User record cannot be null.");
	            }

	            repo.save(student);
	            logger.info("User record added successfully: {}", student);

	        } 
	        catch (StudentsException ex) 
	        {
	            logger.warn("UserServiceException occurred: {}", ex.getMessage());
	            throw ex;
	        } 
	        catch (Exception ex) 
	        {
	            logger.error("An unexpected error occurred while adding the user record.", ex);
	            throw new StudentsException("An error occurred while adding the user record.", ex);
	        }
	    }

	   
//      public Students getStudentById(int id) 
//      {
//        try 
//        {
//           Students student = repo.findById(id)
//                    .orElseThrow(() -> new StudentsException("User not found with ID: " + id));
//            logger.info("Retrieved user: {}", student);
//            return student;
//        } 
//        catch (StudentsException ex) 
//        {
//            logger.warn("UserServiceException occurred: {}", ex.getMessage());
//            throw ex;
//        } catch (Exception ex) 
//        {
//            logger.error("An error occurred while retrieving the user record.", ex);
//            throw new StudentsException("An error occurred while retrieving the user record.", ex);
//        }
//    
//      }
	    public Students findStudentByEmail(String email) 
	      {
	        try 
	        {
	            Students student = repo.findStudentByEmail(email)
	                    .orElseThrow(() -> new StudentsException("User not found with ID: " +email));
	            
	            logger.info("Retrieved user: {}", student);
	            return student;
	        } 
	        catch (StudentsException ex) 
	        {
	            logger.warn("StudentServiceException occurred: {}", ex.getMessage());
	            throw ex;
	        } catch (Exception ex) 
	        {
	            logger.error("An error occurred while retrieving the user record.", ex);
	            throw new StudentsException("An error occurred while retrieving the user record.", ex);
	        }
	    
	      }

	    public Students getStudentByRollNo(String rollNo) {
	        try {
	            // Fetch student from repository using rollNo
	            Students student = repo.findStudentByRollNo(rollNo)
	                    .orElseThrow(() -> new StudentsException("Student not found with Roll No: " + rollNo));

	            // Log info for successful retrieval
	            logger.info("Retrieved student: {}", student);
	            return student;
	        } catch (StudentsException ex) {
	            // Warn in case of a custom exception
	            logger.warn("StudentsException occurred: {}", ex.getMessage());
	            throw ex;
	        } catch (Exception ex) {
	            // Catch other exceptions and log the error
	            logger.error("An error occurred while retrieving the student record.", ex);
	            throw new StudentsException("An error occurred while retrieving the student record.", ex);
	        }
	    }
	    public List<Students> getStudentsByStatus(String status) {
	        return repo.findByStatus(status);
	    }
	    public long getTotalStudents() {
	        return repo.count(); // Returns total number of students
	    }
	    public Map<String, Integer> getStudentStats() {
	        Map<String, Integer> stats = new HashMap<>();

	        // Fetch total students
	        stats.put("total", (int) repo.count()); // Assuming you're using repo.count() to get the total number of students
	        
	        // Fetch placed students count
	        stats.put("placed", repo.findByStatus("placed").size());
	        
	        // Fetch unplaced students count
	        stats.put("unplaced", repo.findByStatus("unplaced").size());

	        return stats;
	    }

		public Students findStudentByUsername(String username) 
		{
			
			try 
	        {
	            Students student = repo.findStudentByUsername(username)
	                    .orElseThrow(() -> new StudentsException("User not found with ID: " +username));
	            
	            logger.info("Retrieved user: {}", student);
	            return student;
	        } 
	        catch (StudentsException ex) 
	        {
	            logger.warn("StudentServiceException occurred: {}", ex.getMessage());
	            throw ex;
	        } catch (Exception ex) 
	        {
	            logger.error("An error occurred while retrieving the student record.", ex);
	            throw new StudentsException("An error occurred while retrieving the student record.", ex);
	        }
		}

		 public Students updateStudent(String id, Students updatedStudent) 
		 {
		        Students existingStudent = repo.findByStudentId(id);
		        if (existingStudent != null) {
		            existingStudent.setUsername(updatedStudent.getUsername());
		            existingStudent.setRollNo(updatedStudent.getRollNo());
		            existingStudent.setStream(updatedStudent.getStream());
		            existingStudent.setBatch(updatedStudent.getBatch());
		            existingStudent.setContactNo(updatedStudent.getContactNo());
		            existingStudent.setCgpa(updatedStudent.getCgpa());

		            return repo.save(existingStudent);  // Save the updated student
		        }

		        return null;  // If student not found, return null
		    }
	  

}

