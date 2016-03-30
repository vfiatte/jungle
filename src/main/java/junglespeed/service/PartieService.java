/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import java.util.ArrayList;
import java.util.List;
import junglespeed.entity.Partie;
import junglespeed.enumeration.Statut;
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
    
    public void creerPartie(){
        List<Partie> listeParties = new ArrayList<>();
        listeParties = (List<Partie>) partieCrudService.findAll();
        System.out.println(listeParties.size());
        if (listeParties.size() <= 4){
            for(int i = 0; i < 4-listeParties.size(); i++){
                Partie p = new Partie();
                p.setStatut(Statut.LIBRE);
                partieCrudService.save(p);
            }
        }
        return;
    }
}
