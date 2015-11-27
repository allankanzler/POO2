/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.domain;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Allan
 */
public class VerificadorDeLetras {

    public static ArrayList<char[]> palavraMaior(ArrayList<char[]> lista) {
        int indiceDaMaior = 0;
        int numeroMaior = 0;

        //eliminarPalavraSemLetrasCompativeis(lista, null);
        for (char[] palavra : lista) {
            if (palavra.length > numeroMaior) {
                numeroMaior = palavra.length;
                indiceDaMaior = lista.indexOf(palavra);
            }

        }
        System.out.println(numeroMaior + " - " + indiceDaMaior + ": " + Arrays.toString(lista.get(indiceDaMaior)));
        Collections.swap(lista, 0, indiceDaMaior);

        return lista;
    }

    public static ArrayList<char[]> palavraMaiorB(ArrayList<char[]> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {

            int indiceDaMaior = 0;
            int numeroMaior = 0;

            //eliminarPalavraSemLetrasCompativeis(lista, null);
            for (char[] palavra : lista) {
                if (lista.indexOf(palavra) >= i) {
                    if (palavra.length > numeroMaior) {
                        numeroMaior = palavra.length;
                        indiceDaMaior = lista.indexOf(palavra);
                    }
                }

            }
            System.out.println(numeroMaior + " - " + indiceDaMaior + ": " + Arrays.toString(lista.get(indiceDaMaior)));
            Collections.swap(lista, i, indiceDaMaior);
        }
        return lista;
    }

    public static ArrayList<Palavra> eliminarPalavraSemLetrasCompativeis(ArrayList<char[]> lista, List<Palavra> banco) {
        boolean temLetraIgual;
        List<char[]> palavrasRemovidas = new ArrayList<>();
        ArrayList<Integer> indicesRetirados = new ArrayList<>();
        ArrayList<Palavra> stringRemovidas = new ArrayList<>();

        for (char[] palavra : lista) {

            /*
            if (lista.indexOf(palavra) == lista.size() - 1) {
                break;
            }
             */
            temLetraIgual = false;
            for (int i = 0; i < lista.size(); i++) {
                for (int j = 0; j < palavra.length; j++) {
                    for (int k = 0; k < lista.get(i).length; k++) {
                        if (!Arrays.toString(palavra).equals(Arrays.toString(lista.get(i)))) {

                            if (palavra[j] == lista.get(i)[k]) {
                                System.out.println(palavra[j] + " | " + lista.get(i)[k] + "| " + Arrays.toString(palavra) + "|" + Arrays.toString(lista.get(i)));
                                temLetraIgual = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (temLetraIgual == false) {
                indicesRetirados.add(lista.indexOf(palavra));
                stringRemovidas.add(banco.get(lista.indexOf(palavra)));
                System.out.println("tirou: " + Arrays.toString(palavra));
            }
        }
        for (char[] p : palavrasRemovidas) {
            lista.remove(p);
        }

        return stringRemovidas;
    }

}
