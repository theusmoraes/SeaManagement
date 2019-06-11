/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.CostureiroDAO;
import Dao.NotafiscalDAO;
import Dao.ProdutoDAO;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class Nota2 {
    public ArrayList<Notafiscal>notaFiscalComcostureiroeProduto(){
        ArrayList<Notafiscal>notas = new ArrayList<>();
        ArrayList<Produto>produtos = new ArrayList<>();
        ArrayList<Costureiro>costureiros = new ArrayList<>();
        Notafiscal nota= new Notafiscal();
        NotafiscalDAO notaDAO= new NotafiscalDAO();
        ProdutoDAO prodao= new ProdutoDAO();
        CostureiroDAO cosdao = new CostureiroDAO();
        Costureiro costureiro = new Costureiro(); 
        Produto produto = new Produto();
               
        produtos=prodao.listaProduto();
        costureiros=cosdao.listaTecido();
        notas=notaDAO.listaNotafiscal();
        
         for (int i = 0; i < notas.size(); i++) {
             for (int j = 0; j < costureiros.size(); j++) {
                 
             if(notas.get(i).getId_funcionario()==costureiros.get(j).getId()){
                 costureiro = new Costureiro();
                 costureiro.setNome(costureiros.get(j).getNome());
                 costureiro.setCpf(costureiros.get(j).getCpf());
                 costureiro.setHorarioTrabalho(costureiros.get(j).getHorarioTrabalho());
                 costureiro.setId(costureiros.get(j).getId());
                 costureiro.setSalario(costureiros.get(j).getSalario());
                 costureiro.setSenha(costureiros.get(j).getSenha());
                 costureiro.setUsuario(costureiros.get(j).getUsuario());
                notas.get(i).setFuncionario(costureiro);
                 
             }
                 
             }
            
             
         }
         for (int i = 0; i < notas.size(); i++) {
             for (int j = 0; j < produtos.size(); j++) {
                 
             if(notas.get(i).getId_produto()==produtos.get(j).getIdproduto()){
                 produto = new Produto();
                 produto.setId_loja(produtos.get(j).getId_loja());
                  produto.setId_tecido(produtos.get(j).getId_tecido());
                  produto.setIdproduto(produtos.get(j).getIdproduto());
                  produto.setNome(produtos.get(j).getNome());
                  produto.setTipoproduto(produtos.get(j).getTipoproduto());
                  produto.setUsadaquant(produtos.get(j).getUsadaquant());
                notas.get(i).setProduto(produto);
                 
             }
                 
             }
            
             
         }
         return notas;
        
        
               
               
               
         
         
     }
    
}
