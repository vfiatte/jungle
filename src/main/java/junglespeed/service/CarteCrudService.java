/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import junglespeed.entity.Carte;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface CarteCrudService extends CrudRepository<Carte, Long>{
    
}
