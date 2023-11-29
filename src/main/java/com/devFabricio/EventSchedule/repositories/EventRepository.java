package com.devFabricio.EventSchedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devFabricio.EventSchedule.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
