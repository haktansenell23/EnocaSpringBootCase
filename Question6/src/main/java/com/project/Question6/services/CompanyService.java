package com.project.Question6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Question6.entities.Company;
import com.project.Question6.repos.CompanyRepository;

@Service
public class CompanyService {
  CompanyRepository _companyRepository;

public CompanyService(CompanyRepository _companyRepository) {
	this._companyRepository = _companyRepository;
}

public List<Company> getAll() {
	// TODO Auto-generated method stub
	return _companyRepository.findAll();
}

public Company saveCompany(Company newCompany) {
	// TODO Auto-generated method stub
	return _companyRepository.save(newCompany);
}

public Optional<Company> findById(Long companyId) {
	// TODO Auto-generated method stub
	return _companyRepository.findById(companyId);
}

public void deleteById(Long companyId) {

	_companyRepository.deleteById(companyId);
}


  



	
	
	
}
