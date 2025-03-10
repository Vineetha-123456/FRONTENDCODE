package com.placementmanagement.repo;

import java.util.List;
import java.util.Optional;
import com.placementmanagement.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentsRepository extends JpaRepository<Students,Long>
{
  @Query(value="select * from Students where username=:username",nativeQuery=true)
	Students findByUsername(@Param("username")String username);

 @Query(value="select * from Students where email=:email",nativeQuery=true)
 	Optional<Students> findStudentByEmail(@Param("email")String email);

 	
 @Query(value="select * from Students where roll_no=:rollNo",nativeQuery=true)
	Optional<Students> findStudentByRollNo(@Param("rollNo")String rollNo);

 @Query(value="select *from Students where status=:status",nativeQuery=true)
 List<Students> findByStatus(@Param("status")String status);

 @Query(value="select *from Students where username=:username",nativeQuery=true)
Optional<Students> findStudentByUsername(String username);
@Query(value="select * from Students where id=:id",nativeQuery=true)
   Students findByStudentId(@Param("id")String id);
 
 

}
