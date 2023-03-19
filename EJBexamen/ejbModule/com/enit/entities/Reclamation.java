package com.enit.entities;

import com.enit.entities.Etudiant;
import com.enit.entities.TypeReclamation;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String titre;
	@Column
	private String description;
	@ManyToOne //@JoinColumn(name="etudiant_id")
	private Etudiant etudiant;
	@ManyToOne //@JoinColumn(name="typeRec_id")
	private TypeReclamation typeRec;
	

	public Reclamation() {
		super();
	}  
	
	
	public Reclamation(int id, String titre, String description, Etudiant etudiant, TypeReclamation typeRec) {
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.etudiant = etudiant;
		this.typeRec = typeRec;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}   
	public TypeReclamation getTypeRec() {
		return this.typeRec;
	}

	public void setTypeRec(TypeReclamation typeRec) {
		this.typeRec = typeRec;
	}
   
}
