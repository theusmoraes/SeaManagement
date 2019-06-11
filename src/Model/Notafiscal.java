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
public class Notafiscal {
    private int idnotafiscal;
    private int id_loja;
    private int id_produto;
    private int id_funcionario;
    private Costureiro funcionario;
    private Produto produto;
    private String mes;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    public Costureiro getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Costureiro funcionario) {
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getIdnotafiscal() {
        return idnotafiscal;
    }

    public void setIdnotafiscal(int idnotafiscal) {
        this.idnotafiscal = idnotafiscal;
    }

    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id) {
        this.id_produto = id;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id) {
        this.id_funcionario = id;
    }
    
    
}
