package com.enit.services;

import java.util.List;

import javax.ejb.Remote;

import com.enit.entities.Etudiant;
import com.enit.entities.Reclamation;
import com.enit.entities.TypeReclamation;

@Remote
public interface ReclamationServiceRemote {
	void ajouterReclamation(Reclamation reclamation);
	void ajouterTypeReclamation(TypeReclamation typeReclamation);
	
	List<Reclamation> listerReclamations();
	List<TypeReclamation> listerTypeReclamations();
	
	boolean existeTypeReclalamtion(String type);
	TypeReclamation chercherTypeReclamationParType(String type);
	List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant);

}
