/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import java.util.List;
import junglespeed.entity.Partie;
import junglespeed.enumeration.Statut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ActualisationService {
    
    @Autowired
    PartieService partieService;
    
    @Autowired
    PartieCrudService partieCrudService;
    
    
//    @Scheduled(fixedDelay = 10000)
    public void MAJPartie(){
        System.out.println("==============================================================================");
        List<Partie> listePartieLibre = (List<Partie>) partieCrudService.findAllByStatut(Statut.LIBRE);
        
        for(Partie p : listePartieLibre){
            partieService.commencerPartie(p);
            
        }
        
    }
}
