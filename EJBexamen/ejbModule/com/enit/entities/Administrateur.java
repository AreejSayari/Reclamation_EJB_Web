package com.enit.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrateur
 *
 */

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table( name ="administrateur")
//@DiscriminatorValue(value="Administrateur")
public class Administrateur extends Utilisateur implements Serializable {


	public Administrateur() {
		super();
	}
	public Administrateur(int id, String email, String password, boolean actif)
	{
		super(id,email,password,actif);
	}
   
}
