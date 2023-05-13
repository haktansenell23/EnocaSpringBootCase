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

import com.project.Question6.entities.Personel;
import com.project.Question6.repos.PersonelRepository;
import com.project.Question6.services.PersonelService;

@RestController
@RequestMapping("/personel")
public class PersonelController {

	private PersonelService  _personelService;
	
	public PersonelController(PersonelService personelService) {
		
		this._personelService = personelService;
	}
	
	@GetMapping
	public List<Personel> getAllPersonels()
	{
		return _personelService.getAllPersonels();
	}
	
	@PostMapping
	public Personel createPersonel(@RequestBody Personel newPersonel)
	{
		return _personelService.CreatePersonel(newPersonel);
	}
	
	@GetMapping("/{personelId}")
	public Personel getPersonelById(@PathVariable Long userId)
	{
		return _personelService.findById(userId).orElse(null);
	}
	
	@PutMapping("/{personelId}")
	public Personel updatePersonel(@PathVariable Long userId,@RequestBody Personel newPersonel)

	
	{
		Optional<Personel> personel = _personelService.findById(userId);
		if (personel.isPresent()) {
			
			Personel foundPersonel = personel.get();
			foundPersonel.setName(newPersonel.getName());
			foundPersonel.setCompany(newPersonel.getCompany());
			return foundPersonel;
		}
		else {
			return null;
		}
	}
	@DeleteMapping("/{personelId}")
	public void deletePersonel(@PathVariable Long userId){
		_personelService.deleteById(userId);
	}
}
