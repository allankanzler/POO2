/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.resources;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allan
 */
public class PalavraTableModel extends GenericTableModel<char[]> {

    private String[] colunas = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11","12","13","14","15","16","17","18","19"};
    private List<char[]> lista;

    private PalavraTableModel() {
        lista = new ArrayList<>();
    }

    public PalavraTableModel(List<char[]> a) {
        this();
        setData(a);
    }

    @Override
    public void setData(List<char[]> list) {
        this.lista.clear();
        this.lista.addAll(list);
        super.fireTableDataChanged();

    }

    @Override
    public char[] getValueAT(int row) {
        return lista.get(row);
    }

    @Override
    public int indexOf(char[] entity) {
        return lista.indexOf(entity);
    }

    @Override
    public void clear() {
        this.lista.clear();
        super.fireTableDataChanged();
    }

    @Override
    public void remove(char[] entity) {
        lista.remove(entity);
        super.fireTableDataChanged();
    }

    @Override
    public void add(char[] entity) {
        lista.add(entity);

    }

    @Override
    public boolean contains(char[] entity) {
        return this.lista.contains(entity);
    }

    @Override
    public List<char[]> list() {
        return lista;
    }

    @Override
    public void updateItem(int idx, char[] entity) {
        lista.set(idx, entity);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 20;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        char[] resposta = lista.get(rowIndex);
        if (columnIndex   <resposta.length ) {
            return (Object) resposta[columnIndex];
        }
        return "";
    }
    
    @Override
	public String getColumnName(int col){
		return colunas[col];
	}
    
    public String[] getColumnNames(){
		return colunas;
	}

}
