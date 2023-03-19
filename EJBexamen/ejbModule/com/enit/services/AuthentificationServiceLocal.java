package com.enit.services;

import com.enit.entities.*;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AuthentificationServiceLocal {
	
	public Utilisateur authentifier(String login, String pwd);
	boolean existeEmail(String login);
	void sauvegarderUtilisateur(Utilisateur utilisateur);
	List<Etudiant> listerEtudiants();
	public Etudiant chercherEtudiant(int id);
}
