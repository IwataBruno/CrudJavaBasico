/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author iwata
 */
public class ProdutoTableModel extends AbstractTableModel{
    
    public static final int COL_ID = 0;
    public static final int COL_NAME = 1;
    public static final int COL_VALOR = 2;
    public ArrayList<Produto> lista;
    
    public ProdutoTableModel(ArrayList<Produto>l){
        
        lista = new ArrayList<Produto>(l);
    }

    @Override
    public int getRowCount() {
        
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Produto produto = lista.get(linhas);
        if(colunas == COL_ID) return produto.getId();
        if(colunas == COL_NAME) return produto.getNome();
        if(colunas == COL_VALOR) return produto.getValor();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_ID) return "id";
        if(colunas == COL_NAME) return "nome";
        if(colunas == COL_VALOR) return "valor";
        return "";
    }
}
