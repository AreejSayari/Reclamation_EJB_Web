package com.enit.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.enit.controller.List;
import com.enit.entities.*;
import com.enit.services.*;

@WebServlet("/controleur")
public class AuthentificationServlet extends HttpServlet{
	ServletContext context ;
	@EJB 
	private AuthentificationServiceLocal metier;
	@EJB 
	private ReclamationServiceLocal metier1;
	
	
	
	public AuthentificationServlet()
	{
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		
		List<Etudiant> L1 = metier.listerEtudiants();
		context.setAttribute("utilisateur", L1);
		context.getRequestDispatcher("/login.jsp").forward(request, response);
		

		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		
		HttpSession session1 = request.getSession(); //Pour enregistrer l'etudiant (var de session)
		HttpSession session = request.getSession(); //pour les messages 
		
		String action=request.getParameter("action");
		if(action.equals("se connecter"))
		{
			String login =request.getParameter("login");
			String password =request.getParameter("pwd");
			Utilisateur u =  metier.authentifier(login, password);
			if(u != null)
			{
				String action1=request.getParameter("action");
				if(u instanceof Etudiant )
				{
					session1.setAttribute("msg", "bienvenue"); /// L1
					session1.setAttribute("msg2", "AVANT le if de l'ajout reclam");
					session1.setAttribute("msg3", "message de l'affichage");

					session1.setAttribute("u", u); //var de session1					
					List<Reclamation> listeReclam = metier1.listerReclamationParEtudiant((Etudiant)u);
					context.setAttribute("reclamationsEtudiant", listeReclam);
					this.getServletContext().getRequestDispatcher("/WEB-INF/etudiant.jsp").forward(request,response);
					
				} else {
					request.setAttribute("etudiants", metier.listerEtudiants());
					request.setAttribute("reclamations",metier1.listerReclamations());
					request.setAttribute("typesReclam", metier1.listerTypeReclamations());						
					this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request,response);
				}
					
			}
							
		}else if(action.equals("creer compte"))
		{
			this.getServletContext().getRequestDispatcher("/nouveauUtilisateur.jsp").forward(request,response);	
			
		}else if(action.equals("Ajouter_Reclam"))
		{
			session1.setAttribute("msg1", "entre dans le if de l'ajout reclam");
			Etudiant u = (Etudiant) session1.getAttribute("u");
			
			Integer id1= Integer.parseInt(request.getParameter("id"));
			String titre =request.getParameter("titre");
			String desc =request.getParameter("desc");
			//String type =request.getParameter("type");
			String type ="type1";
			Reclamation reclamation =new Reclamation();
			reclamation.setId(id1);
			reclamation.setTitre(titre);
			reclamation.setDescription(desc);						
			TypeReclamation tr = new TypeReclamation();
			tr =metier1.chercherTypeReclamationParType(type);
			reclamation.setTypeRec(tr);					
			reclamation.setEtudiant((Etudiant)u);
			
			//Reclamation reclamation = new Reclamation();
			metier1.ajouterReclamation(reclamation);
			this.getServletContext().getRequestDispatcher("/WEB-INF/etudiant.jsp").forward(request,response);						
		
		}
		if(action.equals("creer"))
		{
			//session1.setAttribute("msg4", "entre dans la creaction");
			
			Integer id= Integer.parseInt(request.getParameter("id"));
			String login =request.getParameter("login");
			String password = request.getParameter("pwd");
			
			String nom =request.getParameter("nom");
			String prenom =request.getParameter("prenom");
			session1.setAttribute("msg4", "entre dans la creaction");
			if(!nom.isEmpty() && !prenom.isEmpty())
			{
				Utilisateur e = new Etudiant(id ,login, password , true, nom, prenom);
				metier.sauvegarderUtilisateur(e);
				
				//session1.setAttribute("msg5", "entre dans le if de creaction");
			}
			else 
			{
				Administrateur u = new Administrateur(id,login, password ,true);
				metier.sauvegarderUtilisateur(u);
			}
			this.getServletContext().getRequestDispatcher("/nouveauUtilisateur.jsp").forward(request,response);
	
		}
		if(action.equals("Ajouter_typeRec"))
		{
			Integer id= Integer.valueOf(request.getParameter("id"));  //Integer.parseInt(request.getParameter("id"));
			String titre =request.getParameter("titre");
			TypeReclamation tr = new TypeReclamation( id , titre);
			metier1.ajouterTypeReclamation(tr);
			
			request.setAttribute("etudiants", metier.listerEtudiants());
			request.setAttribute("reclamations",metier1.listerReclamations());
			request.setAttribute("typesReclam", metier1.listerTypeReclamations());
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request,response);
			
			
		}
		if(action.equals("Chercher_mail"))
		{
			String mail =request.getParameter("mail");
			boolean exist = metier.existeEmail(mail);
			String message;
			if (exist)
				message = " Ce mail:' " +mail +"  ' EXISTE";
			else
				message = " Ce mail: ' " +mail +" ' N'EXISTE PAS ";
			session.setAttribute("message", message);
			
			request.setAttribute("etudiants", metier.listerEtudiants());
			request.setAttribute("reclamations",metier1.listerReclamations());
			request.setAttribute("typesReclam", metier1.listerTypeReclamations());
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request,response);
				
			
		}
		if(action.equals("Chercher_Type_Reclamation"))
		{
			String typeRec =request.getParameter("typeRec");
			TypeReclamation tr=  metier1.chercherTypeReclamationParType(typeRec);
			String message1;
			if(tr != null)
				message1 ="Ce type de reclamation existe avec \n ID: " + tr.getId()+ "\n type : " + typeRec ;
			else
				message1 ="Ce type de reclamation n'existe pas";
			session.setAttribute("message1", message1);
			
			request.setAttribute("etudiants", metier.listerEtudiants());
			request.setAttribute("reclamations",metier1.listerReclamations());
			request.setAttribute("typesReclam", metier1.listerTypeReclamations());
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request,response);
			
			
		}
		if(action.equals("Chercher_Reclamation_par_Etudiant"))
		{
			Integer id_etud =Integer.parseInt (request.getParameter("id_etud"));
			Etudiant etudiant = metier.chercherEtudiant(id_etud);
			List<Reclamation> liste= metier1.listerReclamationParEtudiant(etudiant);
			
			String message2;
			if(liste != null){
				message2 ="Les reclamation de cet etudiant : \n" ;
				request.setAttribute("reclam_etd", liste);
			}else
				message2 ="Cet etudiant n'a pas de reclamation";
			session.setAttribute("message2", message2);
			
			request.setAttribute("etudiants", metier.listerEtudiants());
			request.setAttribute("reclamations",metier1.listerReclamations());
			request.setAttribute("typesReclam", metier1.listerTypeReclamations());
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request,response);
			
			
		}
		if(action.equals("Chercher_Type_Reclamation_par_Type"))
		{
			String type =request.getParameter("type");
			TypeReclamation tr =  metier1.chercherTypeReclamationParType(type);
			String message3;
			if(tr != null){
				message3 ="Le type de reclamation est de\n ID: "+ tr.getId()+ "\n ayant comme type : " + type ;
			}else
				message3 ="Pas de type reclamation avec ce type";
			session.setAttribute("message3", message3);
			
			request.setAttribute("etudiants", metier.listerEtudiants());
			request.setAttribute("reclamations",metier1.listerReclamations());
			request.setAttribute("typesReclam", metier1.listerTypeReclamations());
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request,response);
			
			
		}
		
		
		
		
		//this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
	}


	

}
