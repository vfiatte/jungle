/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import junglespeed.entity.Carte;
import junglespeed.entity.Partie;
import junglespeed.entity.Utilisateur;
import junglespeed.enumeration.Couleur;
import junglespeed.enumeration.Statut;
import junglespeed.service.ActualisationService;
import junglespeed.service.CarteCrudService;
import junglespeed.service.CarteService;
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

    @Autowired
    CarteService carteService;

    @Autowired
    CarteCrudService carteCrudService;

    @Autowired
    ActualisationService actualisationService;

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
    public String Rejoindre(@ModelAttribute(value = "utilisateur") Utilisateur u, Model model, HttpSession session) {
        utilisateurCrudService.save(u);

        model.addAttribute("utilisateur", u);
        session.setAttribute("joueur", u);

        Partie p = partieCrudService.findOne(u.getPartie().getId());
//        p.getUtilisateurs().add(u);
        model.addAttribute("maPartie", p);
        p.getUtilisateurs().add(u);
        List<Utilisateur> listeUtilisateurs = p.getUtilisateurs();
        model.addAttribute("mesUtilisateurs", listeUtilisateurs);
        partieCrudService.save(p);
//        actualisationService.MAJPartie();
        utilisateurCrudService.save(u);

        if (listeUtilisateurs.size() == 2) {
            actualisationService.MAJPartie();
            
            String couleur1 = partieService.jouer1(p);
            String couleur2 = partieService.jouer2(p);
            
            model.addAttribute("couleur1", couleur1);
            model.addAttribute("couleur2", couleur2);

            int i = carteCrudService.countByUtilisateurId(u.getId());
            model.addAttribute("nbCartesi", i);

            return "_jeu";
        }
        partieCrudService.save(p);
        return "redirect:/Partie/lister";

    }

//    @RequestMapping(value = "demarrer/{idPartie}", method = RequestMethod.GET)
//    public String Demarrer(@PathVariable(value = "idPartie") long id, Model model) {
//        
//        
//        Partie p = partieCrudService.findOne(id);
//        Utilisateur u1 = p.getUtilisateurs().get(0);
//        Utilisateur u2 = p.getUtilisateurs().get(1);
//        Carte c1 = u1.getCartes().get(0);
//        Carte c2 = u2.getCartes().get(1);
//        model.addAttribute("carte1", c1);
//        model.addAttribute("carte2", c2);
//    }
}
