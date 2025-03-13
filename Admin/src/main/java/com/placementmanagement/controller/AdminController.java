package com.placementmanagement.controller;
import java.util.*; 
import org.springframework.beans.factory.annotation.*; 
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.placementmanagement.entity.Admin;
import com.placementmanagement.service.AdminService;
import jakarta.validation.Valid; 

@RestController
public class AdminController 
{
	@Autowired
    private AdminService service;
	
	@GetMapping("/admin") 
    public List<Admin> listAll()  
    { 
        return service.listAll(); 
    } 
	
    @GetMapping("/admin/{id}") 
    public ResponseEntity<Admin> get(@PathVariable Integer id)  
    { 
        try  
        { 
            Admin admin = service.get(id); 
            return new ResponseEntity<Admin>(admin, HttpStatus.OK); 
        }  
        catch (NoSuchElementException e)  
        { 
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND); 
        }       
    } 
	
    @GetMapping("/{username}")
    public Admin getAdminByUsername(@PathVariable String username) {
        return service.getAdminByUsername(username);
    }

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin loginDetails) {
        Admin admin = service.getAdminByUsername(loginDetails.getUsername());

        if (admin == null) {
            // Return 404 if the username doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Username not found.");
        }

        if (!admin.getPassword().equals(loginDetails.getPassword())) {
            // Return 401 if the password is incorrect
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid password.");
        }

        // If both username and password are correct
        return ResponseEntity.ok("Login successful.");
    }

}


