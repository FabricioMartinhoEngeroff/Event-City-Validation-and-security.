package com.devFabricio.EventSchedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devFabricio.EventSchedule.entities.City; 
 
@Repository
public interface CityRepository extends JpaRepository<City,Long>{
}
