package com.devFabricio.EventSchedule.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devFabricio.EventSchedule.dto.CityDTO;
import com.devFabricio.EventSchedule.entities.City;
import com.devFabricio.EventSchedule.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	public CityRepository repository;

	public List<CityDTO> findAll() {
		List<City> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public CityDTO insert(CityDTO dto) {
			City entity = new City();
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new CityDTO(entity);
	}

}
