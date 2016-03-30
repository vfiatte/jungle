/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.controller;

import junglespeed.entity.Partie;
import junglespeed.entity.Utilisateur;
import junglespeed.service.PartieCrudService;
import junglespeed.service.UtilisateurCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/Joueur")
public class JoueurController {
    
    @Autowired
    PartieCrudService partieCrudService;
    
    @Autowired
    UtilisateurCrudService utilisateurCrudService;
    
    @RequestMapping(value = "ajout")
    public String ajouJoueur(Partie p){
        Utilisateur u = new Utilisateur();
        u.setPartie(p);
        p.getUtilisateurs().add(u);
        partieCrudService.save(p);
        utilisateurCrudService.save(u);
        return "pagePartie";
    }
    
}
