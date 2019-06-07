/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class Estoque {
    private ArrayList<Produto>produto_estocado;

    public Estoque() {
        this.produto_estocado = new ArrayList();
        
    }
    

    public ArrayList<Produto> getProduto_estocado() {
        return produto_estocado;
    }

    public void setProduto_estocado(ArrayList<Produto> produto_estocado) {
        this.produto_estocado = produto_estocado;
    }

    public void cadastraproduto (Produto produto){
        produto_estocado.add(produto);
    }
    
    
}
