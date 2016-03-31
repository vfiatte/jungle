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
import junglespeed.enumeration.Couleur;
import static junglespeed.service.ConfigService.nbCarte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CarteService {
    
    @Autowired
    CarteCrudService carteCrudService;
    
    @Autowired
    UtilisateurCrudService utilisateurCrudService;
            
    public void distribution(Utilisateur u1, Utilisateur u2){
        List<Carte> cartes = new ArrayList<Carte>();
        
        for(int i = 0; i<=nbCarte/5; i++){
            Carte c = new Carte();
            c.setCouleur(Couleur.red);
            carteCrudService.save(c);
            cartes.add(c);
        }
        for(int i = 0; i<=nbCarte/5; i++){
            Carte c = new Carte();
            c.setCouleur(Couleur.yellow);
            carteCrudService.save(c);
            cartes.add(c);
        }
        for(int i = 0; i<=nbCarte/5; i++){
            Carte c = new Carte();
            c.setCouleur(Couleur.blue);
            carteCrudService.save(c);
            cartes.add(c);
        }
        for(int i = 0; i<=nbCarte/5; i++){
            Carte c = new Carte();
            c.setCouleur(Couleur.green);
            carteCrudService.save(c);
            cartes.add(c);
        }
        for(int i = 0; i<=nbCarte/5; i++){
            Carte c = new Carte();
            c.setCouleur(Couleur.purple);
            carteCrudService.save(c);
            cartes.add(c);
        }
        
        List<Carte> jeuMelange = new ArrayList<>();
        int n;
        while (cartes.size() != 0){
            n = (int)((Math.random()) * cartes.size());
            jeuMelange.add(cartes.remove(n));
            
        }
        
        cartes = jeuMelange;
        
        for (int i = 0; i<cartes.size()/2; i++){
            Carte c = jeuMelange.get(i);
            u1.getCartes().add(c);
            c.setUtilisateur(u1);
            utilisateurCrudService.save(u1);
            carteCrudService.save(c);
        }
        
        for (int i = cartes.size()/2 ; i<cartes.size(); i++){
            Carte c = jeuMelange.get(i);
            u2.getCartes().add(c);
            c.setUtilisateur(u2);
            utilisateurCrudService.save(u2);
            carteCrudService.save(c);
        }
    }
}
