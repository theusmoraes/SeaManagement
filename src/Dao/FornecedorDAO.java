/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Fornecedor;
import Model.Tecido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class FornecedorDAO {
    Conexao conexao;

    public FornecedorDAO() {
        conexao = new Conexao();
    }
    //insert into fornecedor(idfornecedor,nome) values (1,"fini");
    //vamos
    //to aqui
    public ArrayList<Fornecedor> listaFonecedor(){
        ArrayList<Fornecedor>fornecedores = new ArrayList<>();
        Fornecedor fornecedor;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from fornecedor");
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               fornecedor= new Fornecedor();
                fornecedor.setIdfornecedor(rs.getInt("idfornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                
               fornecedores.add(fornecedor);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return fornecedores;
        
    }
    
    public void insereFornecedor(String nome){
        String registro = null;
        try{
            String sql= "insert into fornecedor (nome)values (?)";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarFornecedor(int id ,String nome){
        try{
            String sql = "update fornecedor set nome=? where idfornecedor=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarFornecedor(int id){
        try{
            String sql = "delete from fornecedor where idfornecedor=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public Fornecedor SelecioneFornecedor(int id){
        ArrayList<Fornecedor>fornecedores = new ArrayList<>();
        Fornecedor fornecedor;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from fornecedor where idfornecedor=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               fornecedor = new Fornecedor();
                fornecedor.setIdfornecedor(rs.getInt("idfornecedor"));
                fornecedor.setNome(rs.getString("nome"));
               fornecedores.add(fornecedor);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return fornecedores.get(0);
        
    }

}
