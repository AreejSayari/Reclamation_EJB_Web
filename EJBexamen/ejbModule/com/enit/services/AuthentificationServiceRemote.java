package com.enit.services;

import java.util.List;

import javax.ejb.Remote;

import com.enit.entities.Etudiant;
import com.enit.entities.Utilisateur;

@Remote
public interface AuthentificationServiceRemote {
	public Utilisateur authentifier(String login, String pwd);
	boolean existeEmail(String login);
	void sauvegarderUtilisateur(Utilisateur utilisateur);
	List<Etudiant> listerEtudiants();
	public Etudiant chercherEtudiant(int id);

}
