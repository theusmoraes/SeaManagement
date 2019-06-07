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
public class Fornecedor {
    private String nome;
    private ArrayList<String>tecidos;

    public Fornecedor() {
        this.tecidos=new ArrayList();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getTecidos() {
        return tecidos;
    }

    public void setTecidos(ArrayList<String> tecidos) {
        this.tecidos = tecidos;
    }
    
    public void cadastraTecido (String nome){
        tecidos.add(nome);
    }
    
}
