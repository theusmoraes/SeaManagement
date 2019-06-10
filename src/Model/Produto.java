/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ronaldo
 */
public class Produto {
    private int idproduto;
    private String nome;
    private float preco;
    private String tipoproduto;
    private int id_tecido;
    private int id_loja;
    private float usadaquant;
    //testando
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(String tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public int getId_tecido() {
        return id_tecido;
    }

    public void setId_tecido(int id_tecido) {
        this.id_tecido = id_tecido;
    }

    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    public float getUsadaquant() {
        return usadaquant;
    }

    public void setUsadaquant(float usadaquant) {
        this.usadaquant = usadaquant;
    }
    
    
}
