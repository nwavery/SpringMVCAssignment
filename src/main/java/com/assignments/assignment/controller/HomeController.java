package com.assignments.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assignments.assignment.model.Country;
import com.assignments.assignment.service.CountryService;

@Controller
public class HomeController {
	
	@Autowired
	CountryService coService;
	@RequestMapping("/list_countries")
	public String listCountries(Model model)
	{
		List<Country> list=coService.getCountryList();
		model.addAttribute("countries", list);
		return "country";
	}
	
	@RequestMapping("/")
	public String welcome()
	{
		return "index";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCountryPage(@PathVariable(name="id") int id)
	{
		ModelAndView mav = new ModelAndView("edit_country");
		Country co = coService.get(id);
		mav.addObject("country",co);
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCountry(@ModelAttribute("country") Country co)
	{
		coService.saveCo(co);
		return "redirect:/list_countries";
	}
	
	@RequestMapping("/new")
	public String newCountry(Model model)
	{
		Country co = new Country();
		model.addAttribute("country",co);
		return "newcountry";
	}
}
