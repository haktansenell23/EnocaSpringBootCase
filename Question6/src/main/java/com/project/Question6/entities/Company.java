package com.project.Question6.entities;


import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Company")
@Data
public class Company {
    @Id
	Long id;
    @OneToMany(mappedBy="company", cascade = CascadeType.ALL)
    List<Personel>personels;
    String name;
}
