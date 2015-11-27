/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.domain;

/**
 *
 * @author Allan
 */
public class Palavra {
    private String clue;
    private String resposta;

    public Palavra(String clue, String resposta) {
        this.clue = clue;
        this.resposta = resposta;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Palavra{" + "dica: " + clue + ", resposta: " + resposta + '}';
    }
    
    
    
}
