package com.assignments.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignments.assignment.model.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

}
