package com.placementmanagement.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.placementmanagement.entity.Admin; 

public interface AdminRepository extends JpaRepository<Admin, Integer>  
{ 
	  @Query(value = "SELECT * FROM Admin WHERE username = :username", nativeQuery = true)
	    Admin findByAdminUsername(@Param("username")String username);

}
