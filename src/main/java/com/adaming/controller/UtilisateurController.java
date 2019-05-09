package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Utilisateur;
import com.adaming.services.IutilisateurService;

@CrossOrigin("*") // * pour indiquer que tout les ports possibles peuvent etre utiliser. Fait le
					// lien entre la bd et le front pour l'afficher
@RestController
public class UtilisateurController {
	@Autowired
	IutilisateurService utilService;

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public Utilisateur save(@RequestBody Utilisateur utilisateur) {
		return utilService.save(utilisateur);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		utilService.delete(id);
	}

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilService.findAll();
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long id) {
		return utilService.findOne(id);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") Long id,@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUser = utilService.findOne(id);
		currentUser.setNom(utilisateur.getNom());
		currentUser.setPrenom(utilisateur.getPrenom());
		return utilService.save(currentUser);
	}
}
