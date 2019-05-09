package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nom;
	private String prenom;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Profil", joinColumns = @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "idRole", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();

	public Utilisateur(Long idUtilisateur, String nom, String prenom) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur(Long idUtilisateur, String nom, String prenom, Set<Role> roles) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.roles = roles;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



}
