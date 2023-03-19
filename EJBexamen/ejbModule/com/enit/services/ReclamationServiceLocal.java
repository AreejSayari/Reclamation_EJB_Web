package com.enit.services;
import javax.ejb.Local;

import java.util.List;

import com.enit.entities.*;

@Local
public interface ReclamationServiceLocal {
	
	void ajouterReclamation(Reclamation reclamation);
	void ajouterTypeReclamation(TypeReclamation typeReclamation);
	
	List<Reclamation> listerReclamations();
	List<TypeReclamation> listerTypeReclamations();
	
	boolean existeTypeReclalamtion(String type);
	TypeReclamation chercherTypeReclamationParType(String type);
	List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant);

}

