package com.enit.client;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import com.enit.entities.Etudiant;
import com.enit.entities.Utilisateur;
import com.enit.services.AuthentificationServiceLocal;


@Stateless
@WebService
public class Service {
	@EJB (beanName="authen")
	private AuthentificationServiceLocal  metier;
	
	@WebMethod
	public void sauvegarderUtilisateur(@WebParam(name="user") Utilisateur utilisateur)
	{
		metier.sauvegarderUtilisateur(utilisateur);		
	}
	
	@WebMethod
	public Utilisateur authentifier(@WebParam(name="login") String login, @WebParam(name="password") String pwd)
	{
		return metier.authentifier(login, pwd);
	}
	
	@WebMethod
	public List<Etudiant> listerEtudiants()
	{
		return metier.listerEtudiants();			
	}
}
 