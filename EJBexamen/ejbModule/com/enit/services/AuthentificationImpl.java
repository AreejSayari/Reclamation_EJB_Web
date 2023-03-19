package com.enit.services;

import java.util.ArrayList;
import java.util.List;




import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enit.entities.Administrateur;
import com.enit.entities.Etudiant;
import com.enit.entities.TypeReclamation;
import com.enit.entities.Utilisateur;


@Stateless(name="authen")
public class AuthentificationImpl implements AuthentificationServiceLocal, AuthentificationServiceRemote{
	@PersistenceContext(unitName = "EJBexamen")
	private EntityManager em;
	
	@Override
	public Utilisateur authentifier(String login, String pwd)
	{
		Query req = em.createQuery("select c from Etudiant c where c.email like :e and c.password like :p");
		req.setParameter("e", login);
		req.setParameter("p", pwd);
		Utilisateur u =  (Utilisateur) req.getResultList().stream().findFirst().orElse(null);
		if(u!= null)
			return u ;
		else{
			Query req1 = em.createQuery("select d from Administrateur d where d.email like :em and d.password like :pw");
			req1.setParameter("em", login);
			req1.setParameter("pw", pwd);
			Utilisateur u1 = (Utilisateur) req1.getResultList().stream().findFirst().orElse(null); 
				return u1 ;
			}			
	
	}
	@Override
	public boolean existeEmail(String login)
	{
		Query req = em.createQuery("select c from Etudiant c where c.email = :log");
		req.setParameter("log" , login);
		Etudiant e = (Etudiant)req.getSingleResult();
		if(e!= null)
			return true;
		else
		{
			Query req1 = em.createQuery("select d from Administrateur d where d.email = :log");
			req1.setParameter("log" , login);
			Administrateur a = (Administrateur) req1.getSingleResult();
			if(a!= null)
				return true;
			
		}
		return false;
		
		
		/*Etudiant e =em.find(Etudiant.class, login);
		if(e  != null)
			return true;
		else {
			Administrateur a=em.find(Administrateur.class,login);
			if(a  != null)
				return true;
		}
		return false;*/
		
	}
	@Override @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sauvegarderUtilisateur(Utilisateur utilisateur)
	{
		if (utilisateur instanceof Etudiant )
		{
			em.persist((Etudiant)utilisateur);
			em.flush();
			
		}else if (utilisateur instanceof Administrateur)
		{
			em.persist((Administrateur)utilisateur);
			em.flush();
		}
	
		
	}
	@Override
	public List<Etudiant> listerEtudiants()
	{
		Query req = em.createQuery("select c from Etudiant  c ");
		List<Etudiant> etudiants = req.getResultList();	
		return etudiants;
		
	}
	@Override
	public Etudiant chercherEtudiant(int id)
	{
		Query req = em.createQuery("select c from Etudiant  c where id=:i ");
		req.setParameter("i", id);	 
		return (Etudiant) req.getSingleResult();
	}

}
