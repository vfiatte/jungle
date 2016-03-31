/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import java.util.ArrayList;
import java.util.List;
import junglespeed.entity.Partie;
import junglespeed.entity.Utilisateur;
import junglespeed.enumeration.Statut;
import static junglespeed.enumeration.Statut.DEMARRE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            if (p.getStatut().equals(DEMARRE)){
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
}

