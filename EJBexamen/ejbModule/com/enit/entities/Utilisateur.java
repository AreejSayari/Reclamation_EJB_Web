package com.enit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

//@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS )
//@DiscriminatorColumn (name ="role" ,discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue(value="Utilisateur")
@MappedSuperclass
abstract public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private boolean actif;


	public Utilisateur() {
		super();
	}  
	
	   
	public Utilisateur(int id, String email, String password, boolean actif) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.actif = actif;
		}
	/*public Utilisateur( String email, String password, boolean actif) {
		super();
		this.email = email;
		this.password = password;
		this.actif = actif;
	}*/
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
   
}
