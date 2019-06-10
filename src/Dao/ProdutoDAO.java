/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Maquina;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class ProdutoDAO {
    Conexao conexao;

    public ProdutoDAO() {
    conexao = new Conexao();
    }
    
    public ArrayList<Produto> listaProduto(){
        ArrayList<Produto>produtos = new ArrayList<>();
        Produto produto;
        
        // insert into produto(nome,preco,tipoproduto,id_tecido,usadaquant,id_loja) values ("calça",49.99,"moletom",1,12,1);

        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from produto");
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               produto= new Produto();
                produto.setIdproduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setTipoproduto(rs.getString("tipoproduto"));
                produto.setId_tecido(rs.getInt("id_tecido"));
                produto.setUsadaquant(rs.getFloat("usadaquant"));
                produto.setId_loja(rs.getInt("id_loja"));
               produtos.add(produto);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return produtos;
        
    }
    
    public void insereProduto(String nome, float preco,String tipoproduto, int id_tecido, int usadaquant){
        String registro = null;
        try{
            String sql= "INSERT INTO produto(nome,preco,tipoproduto,id_tecido,usadaquant,id_loja) VALUES (?,?,?,?,?,1)";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setFloat(2,preco);
            stmt.setString(3,tipoproduto);
            stmt.setInt(4,id_tecido);
            stmt.setFloat(5,usadaquant);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarProduto(int idproduto,String nome, float preco,String tipoproduto, int id_tecido, int usadaquant){
        try{
            String sql = "update produto set nome=? ,preco =?,tipoproduto =?,id_tecido=?,usadaquant=? where idproduto=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setFloat(2,preco);
            ps.setString(3,tipoproduto);
            ps.setInt(4,id_tecido);
            ps.setFloat(5,usadaquant);
            ps.setInt(6,idproduto);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarProduto(int id){
        try{
            String sql = "delete from produto where idproduto= ?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public Produto SelecioneProduto(int id){
        ArrayList<Produto>produtos = new ArrayList<>();
        Produto produto;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from produto where idproduto=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               produto= new Produto();
                produto.setIdproduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setTipoproduto(rs.getString("tipoproduto"));
                produto.setId_tecido(rs.getInt("id_tecido"));
                produto.setUsadaquant(rs.getFloat("usadaquant"));
                produto.setId_loja(rs.getInt("id_loja"));
               produtos.add(produto);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return produtos.get(0);
        
    }
}
