package com.project.Question6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Question6.entities.Personel;
import com.project.Question6.repos.PersonelRepository;

@Service
public class PersonelService {

	PersonelRepository _personelRepository;
	
	public PersonelService(PersonelRepository personelRepository) {
		_personelRepository	=personelRepository;
				}

	public List<Personel> getAllPersonels() {

		return _personelRepository.findAll();
	}

	public Personel CreatePersonel(Personel newPersonel) {
		// TODO Auto-generated method stub
		return _personelRepository.save(newPersonel);
	}

	public Optional<Personel> findById(Long userId) {
		// TODO Auto-generated method stub
		return _personelRepository.findById(userId);
	}

	

	public void deleteById(Long userId) {
		// TODO Auto-generated method stub
		_personelRepository.deleteById(userId);
	}
}
