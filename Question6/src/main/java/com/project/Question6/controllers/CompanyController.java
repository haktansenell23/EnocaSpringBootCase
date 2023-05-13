package com.project.Question6.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Question6.entities.Company;
import com.project.Question6.entities.Personel;
import com.project.Question6.repos.CompanyRepository;
import com.project.Question6.repos.PersonelRepository;
import com.project.Question6.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyService _companyService;
	
	public CompanyController(CompanyService _companyService) {
		
		this._companyService= _companyService;
	}
	
	@GetMapping
	public List<Company> getAllCompanies()
	{
		return _companyService.getAll();
	}
	
	@PostMapping
	public Company createCompany(@RequestBody Company newCompany)
	{
		return _companyService.saveCompany(newCompany);
	}
	
	@GetMapping("/{companyId}")
	public Company getCompanyById(@PathVariable Long companyId)
	{
		return _companyService.findById(companyId).orElse(null);
	}
	
	@PutMapping("/{companyId}")
	public Company updateCompany(@PathVariable Long companyId,@RequestBody Company newCompany)

	
	{
		Optional<Company> companies = _companyService.findById(companyId);
		if (companies.isPresent()) {
			
			Company foundCompany = companies.get();
			foundCompany.setName(newCompany.getName());
			
			return foundCompany;
		}
		else {
			return null;
		}
	}
	@DeleteMapping("/{companyId}")
	public void deleteCompany(@PathVariable Long companyId){
		_companyService.deleteById(companyId);
	}
}
