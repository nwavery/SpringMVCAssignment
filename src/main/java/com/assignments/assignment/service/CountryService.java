package com.assignments.assignment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignments.assignment.model.Country;
import com.assignments.assignment.repo.CountryRepo;

@Service
public class CountryService {
	
	@Autowired
	CountryRepo coRepo;
	
	public List<Country> getCountryList()
	{
		return coRepo.findAll();
	}
	public void delete(int id)
	{
		coRepo.deleteById(id);
	}
	public Country get(int id)
	{
		return coRepo.findById(id).get();
	}
	public void saveCo(Country c)
	{
		coRepo.save(c);
	}
}
