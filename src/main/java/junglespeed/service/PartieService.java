/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import java.util.ArrayList;
import java.util.List;
import junglespeed.entity.Carte;
import junglespeed.entity.Partie;
import junglespeed.entity.Utilisateur;
import junglespeed.enumeration.Statut;
import static junglespeed.enumeration.Statut.DEMARRE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 *
 * @author admin
 */
@Service
public class PartieService {

    @Autowired
    PartieCrudService partieCrudService;

    @Autowired
    CarteService carteService;

    @Autowired
    CarteCrudService carteCrudService;

    @Autowired
    UtilisateurCrudService utilisateurCrudService;

    public void creerPartie() {
        List<Partie> listeParties = new ArrayList<>();
        listeParties = (List<Partie>) partieCrudService.findAllByStatut(Statut.LIBRE);
        if (listeParties.size() <= 4) {
            for (int i = 0; i < 4 - listeParties.size(); i++) {
                Partie p = new Partie();
                p.setStatut(Statut.LIBRE);
                partieCrudService.save(p);
            }
        }
        return;
    }

//    public void 
    public void commencerPartie(Partie p) {
        if (p.getUtilisateurs().size() == 2) {
            if (p.getStatut().equals(DEMARRE)) {
                return;
            } else {
                p.setStatut(Statut.DEMARRE);
                carteService.distribution(p.getUtilisateurs().get(0), p.getUtilisateurs().get(1));
                partieCrudService.save(p);
                utilisateurCrudService.save(p.getUtilisateurs().get(0));
                utilisateurCrudService.save(p.getUtilisateurs().get(1));

            }

        }
    }

    public String jouer1(Partie p) {
        int n = (int) (Math.random()*10);
        System.out.println(n);
        Utilisateur u1 = p.getUtilisateurs().get(0);

        List<Carte> listeu1 = carteCrudService.findByUtilisateurId(u1.getId());
        Carte c1 = listeu1.get(8);

        String couleur1 = c1.getCouleur().toString();

        return couleur1;

    }

    public String jouer2(Partie p) {
        Utilisateur u2 = p.getUtilisateurs().get(1);

        List<Carte> listeu2 = carteCrudService.findByUtilisateurId(u2.getId());
        Carte c2 = listeu2.get(8);

        String couleur2 = c2.getCouleur().toString();

        return couleur2;

    }
}
