package com.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Utilisateur;
import com.adaming.repositories.UtilisateurRepository;
@Service
public class UtilisateurService implements IutilisateurService{

	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void delete(Long id) {
		utilisateurRepository.delete(id);
		
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long id) {
		return utilisateurRepository.findOne(id);
	}

	

}
