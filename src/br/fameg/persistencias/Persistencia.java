/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.persistencias;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allan
 */
public class Persistencia implements IEntity<char[]> {
    
    public static ArrayList<char[]> listaDeResposta = new ArrayList<>();

    @Override
    public void save(char[] t) {
       listaDeResposta.add(t);
    }

    @Override
    public char[] findByID(int id) {
        return null;
        
    }

    @Override
    public List<char[]> list() {
        return listaDeResposta;
    }

    @Override
    public void delete(char[] t) {
        listaDeResposta.remove(t);
    }

   
}
