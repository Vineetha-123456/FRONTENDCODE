package com.placementmanagement.controller;
import com.placementmanagement.entity.Admin;
import com.placementmanagement.entity.Students;
import com.placementmanagement.service.StudentsService;
import com.placementmanagement.exception.StudentsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;
   
    // Register a new user (signup)
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Students student) {
        try {
            // Call service method to register user
            Students savedUser = studentsService.registerStudent(student);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (StudentsException e) {
            // Log the custom exception details
            System.out.println("StudentsException: " + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Log the generic exception details
            e.printStackTrace();  // Print stack trace to the console
            return new ResponseEntity<>("An error occurred while registering the user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    

    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            // Call service method to login user
            Students student = studentsService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
            if (student != null) {
                return new ResponseEntity<>(student, HttpStatus.OK); // Login successful
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } catch (StudentsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred during login.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/students") 
    public List<Students> listAll()  
    { 
        return studentsService.listAll(); 
    } 

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Students> getStudentsByEmail(@PathVariable String email) {
        try {
           Students student = studentsService.findStudentByEmail(email);
            return new ResponseEntity<Students>(student, HttpStatus.OK);
        } catch (StudentsException e) {
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<Students>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<Students> getStudentsByUsername(@PathVariable String username) {
        try {
           Students student = studentsService.findStudentByUsername(username);
            return new ResponseEntity<Students>(student, HttpStatus.OK);
        } catch (StudentsException e) {
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<Students>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/rollNo/{rollNo}")
    public ResponseEntity<Students> getStudent(@PathVariable String rollNo) {
    	try {
        Students student = studentsService.getStudentByRollNo(rollNo);
        return new ResponseEntity<Students>(student, HttpStatus.OK);
    } catch (StudentsException e) {
        return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
        return new ResponseEntity<Students>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    


    // Add new user (for admin)
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Students student) {
        try {
            studentsService.addStudent(student);
            return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while adding the user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/student/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable String id, @RequestBody Students updatedStudent) {
        Students updated = studentsService.updateStudent(id, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok(updated);  // Return updated student details
        } else {
            return ResponseEntity.notFound().build();  // If student not found, return 404
        }
    }
    @GetMapping("/total")
    public long getTotalStudents() {
        return studentsService.getTotalStudents(); // Returns total students count
    }
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Integer>> getStudentStats() {
        try {
            Map<String, Integer> stats = new HashMap<>();
            
            // Fetch total students, placed students, and unplaced students
            stats.put("total", (int) studentsService.getTotalStudents());
            stats.put("placed", studentsService.getStudentsByStatus("placed").size());
            stats.put("unplaced", studentsService.getStudentsByStatus("unplaced").size());

            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}







