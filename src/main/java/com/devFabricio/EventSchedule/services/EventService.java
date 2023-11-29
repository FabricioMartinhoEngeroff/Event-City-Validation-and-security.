package com.devFabricio.EventSchedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devFabricio.EventSchedule.dto.EventDTO;
import com.devFabricio.EventSchedule.entities.City;
import com.devFabricio.EventSchedule.entities.Event;
import com.devFabricio.EventSchedule.repositories.CityRepository;
import com.devFabricio.EventSchedule.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	public EventRepository repository;

	@Autowired
	private CityRepository cityRepository;

	public Page<EventDTO> findAllPaged(Pageable pageable) {
		Page<Event> list = repository.findAll(pageable);
		return list.map(x -> new EventDTO(x));

	}

	@Transactional
	public EventDTO insert(EventDTO dto) throws Exception {
		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());

		City city = cityRepository.findById(dto.getCityId()).orElseThrow(() -> new Exception("City not found"));
		entity.setCity(city);

		entity = repository.save(entity);
		return new EventDTO(entity);
	}

}
