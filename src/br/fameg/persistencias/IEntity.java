/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.persistencias;

import java.util.List;



/**
 *
 * @author crfranco
 */
public interface IEntity <T>{
    
    public void save(T t);
    
    public T findByID(int id);
    
    public List<T> list();
    
    public void delete(T t);
    
}
