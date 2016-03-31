/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import java.util.List;
import junglespeed.entity.Carte;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface CarteCrudService extends CrudRepository<Carte, Long>{
    public int countByUtilisateurId(long id);
    public List<Carte> findByUtilisateurId(long id);
}
