/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Allan
 */
public class SalvadorDeBancoDePalavras {

    public static void gravarBanco(ArrayList<Palavra> banco, File file) {

        ArrayList<char[]> listaChar = TransformadorDePalavraEmVetor.transformar(banco);
        List<Palavra> palavrasRetirados = VerificadorDeLetras.eliminarPalavraSemLetrasCompativeis(listaChar, banco);

        for (Palavra p : palavrasRetirados) {
            banco.remove(p);
        }

        if (banco.size() > 1) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (Palavra card : banco) {
                    writer.write(card.getClue() + "/");
                    writer.write(card.getResposta());
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(palavrasRetirados.size()>0) {
                JOptionPane.showMessageDialog(null, "As seguintes palavras foram retiradas por falta de compatibilidade: \n"
                        + Arrays.toString(palavrasRetirados.toArray()));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Menos de duas palavras com letras compativas adicionadas, banco não será salvo");
        }
    }

}
