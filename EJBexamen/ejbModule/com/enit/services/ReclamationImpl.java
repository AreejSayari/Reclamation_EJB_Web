package com.enit.services;


import java.util.List;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enit.entities.*;


@Stateless(name="reclam")
public class ReclamationImpl implements ReclamationServiceLocal, ReclamationServiceRemote {
	@PersistenceContext(unitName = "EJBexamen")
	private EntityManager em;

	
	@Override @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void ajouterReclamation(Reclamation reclamation)
	{
		em.merge(reclamation);
		//em.persist(reclamation);
		em.flush();
	}
	@Override
	public void ajouterTypeReclamation(TypeReclamation typeReclamation)
	{
		em.persist(typeReclamation);
	}
	
	public List<Reclamation> listerReclamations()
	{
		Query req = em.createQuery("select c from Reclamation c");
		return req.getResultList();
	}
	public List<TypeReclamation> listerTypeReclamations()
	{
		Query req = em.createQuery("select c from TypeReclamation c");
		return req.getResultList();
	}
	
	public boolean existeTypeReclalamtion(String type)
	{
		TypeReclamation tp =em.find(TypeReclamation.class, type);
		if (tp == null)
			return false;
		else 
			return true;
			
	}
	public TypeReclamation chercherTypeReclamationParType(String type)
	{
		Query req = em.createQuery("select c.id from TypeReclamation c where c.type = :typeR");
		req.setParameter("typeR" , type);
		TypeReclamation tr = new TypeReclamation((int) req.getSingleResult(),type);
		return tr;
		
		/*TypeReclamation tp =em.find(TypeReclamation.class, type);
		if(tp == null ) throw new RuntimeException("type introuvable");		
		return tp ;*/
	}
	public List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant)
	{
		Query req = em.createQuery("select c from Reclamation c where c.etudiant.id = :id_et");
		req.setParameter("id_et" , etudiant.getId());
		return req.getResultList();
	}


}

