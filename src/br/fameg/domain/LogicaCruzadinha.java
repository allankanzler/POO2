/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Allan
 */
public class LogicaCruzadinha {

    static int contadorSeguranca;
    static int contadorDois;

    public static List<char[]> fazerCruzadinha(List<char[]> listaRecebida) {
        if (contadorSeguranca == 0) {
            contadorDois = 0;
        }
        contadorSeguranca = 0;
        if(contadorDois==0)
            listaRecebida = VerificadorDeLetras.palavraMaiorB((ArrayList<char[]>) listaRecebida);
        
        List<char[]> listaRetorno;

        listaRetorno = encherComEspacosVazios();

        for (char[] palavra : listaRecebida) {

            if (contadorSeguranca == 0) {
                listaRetorno = botarPalavraNoMeio(palavra, listaRetorno);
                contadorSeguranca++;
            } else {
                encaixarDemaisPalavras(palavra, listaRetorno, listaRecebida, listaRecebida.indexOf(palavra));
            }
            System.out.println(contadorSeguranca);

        }
        System.out.println("um " + contadorSeguranca + " dois " + contadorDois);        
        return listaRetorno;
    }

    private static List<char[]> encherComEspacosVazios() {
        List<char[]> retorno = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            char[] a = new char[20];
            for (int j = 0; j < 20; j++) {
                a[j] = ' ';
            }
            retorno.add(a);
        }
        return retorno;
    }

    private static List<char[]> botarPalavraNoMeio(char[] palavra, List<char[]> listaRetorno) {
        int j = 0;
        for (int i = 6; j < palavra.length; i++) {

            listaRetorno.get(10)[i] = palavra[j];
            j++;
        }
        return listaRetorno;
    }

    private static List<char[]> encaixarDemaisPalavras(char[] palavra, List<char[]> listaRetorno, List<char[]> listaRecebida, int index) {
        contadorSeguranca++;
        System.out.println(contadorSeguranca);

        if (contadorSeguranca > listaRecebida.size() * 5) {
            if (contadorDois == listaRecebida.size()*5) {
                return listaRetorno;
            }

            Collections.shuffle(listaRecebida);
            contadorDois++;
            listaRetorno=encherComEspacosVazios();
            fazerCruzadinha(listaRecebida);            
        }

        for (char[] linha : listaRetorno) {
            for (int i = 0; i < palavra.length; i++) {
                for (int j = 0; j < linha.length; j++) {
                    if (linha[j] == palavra[i]) {
                        
                        char antes=' ';
                        char depois=' ';
                        if(j-1>=0)
                            antes=linha[j - 1];
                        if(j+1<linha.length)
                            depois=linha[j + 1];

                        if (antes == ' ' && depois == ' ') {
                            if (verificarPossibilidadeDeEnxaixeDaPalavraVertical(palavra, listaRetorno, j, listaRetorno.indexOf(linha), i)) {
                                adicionarVerticalmente(palavra, listaRetorno, j, listaRetorno.indexOf(linha), i);
                                return listaRetorno;
                            }
                        } else {
                            int l = listaRetorno.indexOf(linha);
                            if(l - 1>=0)
                                antes=listaRetorno.get(l - 1)[j];
                            if((l+1)<listaRetorno.size())
                                depois=listaRetorno.get(l + 1)[j];
                            if (antes == ' ' && depois == ' ') {
                                if (verificarPossibilidadeDeEnxaixeDaPalavrahorizontal(palavra, listaRetorno, j, listaRetorno.indexOf(linha), i)) {
                                    adicionaHorizoltamente(palavra, listaRetorno, j, listaRetorno.indexOf(linha), i);
                                    return listaRetorno;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(index + " | " + listaRecebida.size() + "--" + Arrays.toString(listaRecebida.get(index)));

        if (index == listaRecebida.size() - 1) {
            if(contadorDois>=listaRecebida.size()*5){
            System.out.println("voltou aqui");
            return listaRetorno;
            }else{
                Collections.shuffle(listaRecebida);
                listaRetorno=encherComEspacosVazios();
                contadorDois++;
                fazerCruzadinha(listaRecebida);                
            }                
        }
        //MELHORAR ESSE METODO!!
        //Collections.swap(listaRecebida, index, listaRecebida.size() - 1);
        colocarPalavraNofim(listaRecebida, index);

        System.out.println("AQUI!! : " + index + " :" + Arrays.toString(listaRecebida.get(index)) + "--" + Arrays.toString(listaRecebida.get(listaRecebida.size() - 1)));

        encaixarDemaisPalavras((char[]) listaRecebida.get(index), listaRetorno, listaRecebida, index);

        return listaRetorno;
    }
    
     private static List<char[]> colocarPalavraNofim(List<char[]> retorno,int indice){
        
        for(indice=indice;indice<retorno.size()-1;indice++){
            Collections.swap(retorno, indice, indice+1);
        }
         
        return retorno;
    }
    

    private static void adicionarVerticalmente(char[] palavra, List<char[]> listaRetorno, int colunaTab, int linhaTab, int indiceLetra) {
        int i = colunaTab - indiceLetra;
        for (int k = 0; k < palavra.length; k++) {
            if (palavra[k] != listaRetorno.get(linhaTab)[i]) {
                listaRetorno.get(linhaTab)[i] = palavra[k];
            }
            i++;
        }
    }

    public static boolean verificarPossibilidadeDeEnxaixeDaPalavraVertical(char[] palavra, List<char[]> listaRetorno, int colunaTab, int linhaTab, int indiceLetra) {
        boolean retorno = true;
        int i = colunaTab - indiceLetra;
        try {
            for (int k = 0; k < palavra.length; k++) {
                
                System.out.println(palavra[k] +"--"+ listaRetorno.get(linhaTab)[i]);

                if (palavra[k] != listaRetorno.get(linhaTab)[i] && listaRetorno.get(linhaTab)[i] != ' ') {
                    System.out.println(palavra[k] + "-aqui-" + listaRetorno.get(linhaTab)[i]);
                    return false;
                }
                i++;

            }
        } catch (Exception e) {
            retorno = false;            
        }

        return retorno;
    }

    private static void adicionaHorizoltamente(char[] palavra, List<char[]> listaRetorno, int colunaTab, int linhaTab, int indiceLetra) {
        int i = linhaTab - indiceLetra;
        for (int k = 0; k < palavra.length; k++) {
            if (palavra[k] != listaRetorno.get(i)[colunaTab]) {
                listaRetorno.get(i)[colunaTab] = palavra[k];
            }
            i++;
        }
    }

    public static boolean verificarPossibilidadeDeEnxaixeDaPalavrahorizontal(char[] palavra, List<char[]> listaRetorno, int colunaTab, int linhaTab, int indiceLetra) {
        boolean retorno = true;
        int i = linhaTab - indiceLetra;
        try{
        for (int k = 0; k < palavra.length; k++) {
            
            if (listaRetorno.get(i)[colunaTab] != ' ' && palavra[k] != listaRetorno.get(i)[colunaTab]) {
                retorno = false;
            }
            i++;
        }
        }catch (Exception e){
            retorno = false;
        }
        return retorno;
    }
    
   

}
