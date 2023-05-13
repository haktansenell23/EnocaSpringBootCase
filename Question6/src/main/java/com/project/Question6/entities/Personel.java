package com.project.Question6.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Personel")
@Data
public class Personel {
	    @Id
		Long id;
	    @ManyToOne
	    @JoinColumn(name="company_id",nullable=false)
	    Company company;
	    String name;
}
