/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.testers;

import br.fameg.domain.Palavra;
import br.fameg.domain.TransformadorDePalavraEmVetor;
import br.fameg.domain.VerificadorDeLetras;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Allan
 */
public class Tester {
    public static void main(String[] args) {
        ArrayList<Palavra> array = new ArrayList<>();
        
        array.add(new Palavra("lalala","bacon"));
        
        array.add(new Palavra("lalala","cerveja"));
        array.add(new Palavra("lalala","tungstenio"));
        
        array.add(new Palavra("lalala","pinga"));
        
        System.out.println("vetor: "+array);    
        
        
        ArrayList<char[]> vetor = TransformadorDePalavraEmVetor.transformar(array);
        System.out.println("----");
        for(char[] c:vetor){
            System.out.println("vetor: "+Arrays.toString(c));
        }
        System.out.println("----");
        System.out.println("NOVO TESTE!!!");
        
        vetor = VerificadorDeLetras.palavraMaior(vetor);
        System.out.println("-");
        for(char[] c:vetor){
            System.out.println("vetor: "+Arrays.toString(c));
        }
        
    }
            
    
}
