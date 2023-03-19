package com.enit.entities;

import com.enit.entities.Utilisateur;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
@Entity
@Table( name ="etudiant")
//@DiscriminatorValue(value="Etudiant")
public class Etudiant extends Utilisateur implements Serializable {
	@Column
	private String nom;
	@Column
	private String prenom;

	@OneToMany( mappedBy="etudiant",cascade = CascadeType.PERSIST)
	private Collection<Reclamation> reclamations;
	

	public Etudiant() {
		super();
		//reclamations= new ArrayList<Reclamation> ();
	}   
	public Etudiant(int id, String email, String password, boolean actif ,String nom, String prenom) {
		super(id,email,password,actif);
		this.nom = nom;
		this.prenom = prenom;

	}
	/*public Etudiant(String email, String password, boolean actif ,String nom, String prenom) {
		super(email,password,actif);
		this.nom = nom;
		this.prenom = prenom;

	}*/
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public Collection<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Collection<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	
   
}
