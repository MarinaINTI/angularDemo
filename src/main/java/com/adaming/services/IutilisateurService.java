package com.adaming.services;

import java.util.List;

import com.adaming.entities.Utilisateur;

public interface IutilisateurService {

	public Utilisateur save(Utilisateur utilisateur);

	public void delete(Long id);

	public List<Utilisateur> findAll();

	public Utilisateur findOne(Long id);

}
