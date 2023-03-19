package com.enit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeReclamation
 *
 */
@Entity

public class TypeReclamation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String type;
	//@ElementCollection
	@OneToMany(cascade = CascadeType.PERSIST)
	private Collection<Reclamation> reclamations;
	
	public TypeReclamation() {
		super();
		//reclamations= new ArrayList<Reclamation> ();
	}  
	
	public TypeReclamation(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}  
	
	public Collection<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Collection<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
   
}
