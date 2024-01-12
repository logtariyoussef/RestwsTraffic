package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Traffic;

public interface TrafficRepository extends JpaRepository<Traffic,Long>{
 
	/*@Query("SELECT t FROM Traffic t WHERE t.gouv = :gouv")
    List<Traffic> findByGouv(@Param("gouv") String gouv);*/
	
	List<Traffic> findByGouv(@Param("gouv") String gouv);
}
