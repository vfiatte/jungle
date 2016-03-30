/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.controller;

import junglespeed.entity.Partie;
import junglespeed.entity.Utilisateur;
import junglespeed.enumeration.Statut;
import junglespeed.service.PartieCrudService;
import junglespeed.service.PartieService;
import junglespeed.service.UtilisateurCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/Partie")
public class PartieController {

    @Autowired
    UtilisateurCrudService utilisateurCrudService;

    @Autowired
    PartieCrudService partieCrudService;

    @Autowired
    PartieService partieService;

    @RequestMapping(value = "lister", method = RequestMethod.GET)
    public String lister(Model model) {
        Iterable<Partie> listeParties = partieCrudService.findAllByStatut(Statut.LIBRE);
        model.addAttribute("mesParties", listeParties);
        return "_listerParties";

    }

    @RequestMapping(value = "creer", method = RequestMethod.GET)
    public String creer(Model model) {
        System.out.println("controller");
        partieService.creerPartie();

        return "redirect:/Partie/lister";
    }

    @RequestMapping(value = "rejoindre/{idPartie}", method = RequestMethod.GET)
    public String Rejoindre(@PathVariable(value = "idPartie") long id, Model model) {
        Partie p = partieCrudService.findOne(id);
        Utilisateur u = new Utilisateur();
        u.setPartie(p);
        model.addAttribute("utilisateur", u);

        return "_ajoutJoueur";
    }

    @RequestMapping(value = "rejoindre", method = RequestMethod.POST)
    public String Rejoindre(@ModelAttribute(value = "utilisateur") Utilisateur u) {
        utilisateurCrudService.save(u);
        
        return "redirect:/Partie/lister";
    }
}
