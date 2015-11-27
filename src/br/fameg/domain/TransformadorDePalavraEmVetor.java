/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Allan
 */
public class TransformadorDePalavraEmVetor {
    
    public static ArrayList<char[]> transformar(ArrayList<Palavra> lista){
        
        ArrayList<char[]> listaVetor = new ArrayList<>();
            
            for(Palavra p :lista){
                String resposta = p.getResposta();                
                char[] respostaVetor = resposta.toCharArray();               
                listaVetor.add(respostaVetor);
            }        
        return listaVetor;
    }
    
}
