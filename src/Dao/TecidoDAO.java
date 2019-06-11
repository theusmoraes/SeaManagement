/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Tecido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Ronaldo
 */
public class TecidoDAO {
    Conexao conexao;

    public TecidoDAO() {
        conexao = new Conexao();  
    }
    //insert into tecido (idtecido,nome,disponivel,ventido,id_fonecedor,id_loja)values (1,"seda",50,10,1,1);
    public ArrayList<Tecido> listaTecido(){
        ArrayList<Tecido>tecidos = new ArrayList<>();
        Tecido tecido;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from tecido");
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               tecido = new Tecido();
                tecido.setId(rs.getInt("idtecido"));
                tecido.setNome(rs.getString("nome"));
                tecido.setVendido(rs.getFloat("vendido"));
                tecido.acrescentaTecido(rs.getFloat("disponivel"));
                tecido.setId_fornecedor(rs.getInt("id_fonecedor"));
                tecido.setId_loja(rs.getInt("id_loja"));
               tecidos.add(tecido);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return tecidos;
        
    }
    
    public void insereTecido(String nome, float disponivel,int id_fornecedor){
        String registro = null;
        try{
            String sql= "INSERT INTO tecido(nome,disponivel,vendido,id_fonecedor,id_loja) VALUES (?,?,0,?,1)";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setFloat(2,disponivel);
            stmt.setInt(3,id_fornecedor);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarTecido(int id ,String nome, float disponivel,float vendido,int id_fornecedor){
        try{
            String sql = "update tecido set nome=?, disponivel=?,vendido=? ,id_fonecedor=? where idtecido=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setFloat(2,disponivel);
            ps.setFloat(3, vendido);
            ps.setInt(4,id_fornecedor);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarTecido(int id){
        try{
            String sql = "delete from tecido where idtecido=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public Tecido SelecioneTecido(int id){
        ArrayList<Tecido>tecidos = new ArrayList<>();
        Tecido tecido;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from tecido where idtecido=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               tecido = new Tecido();
                tecido.setId(rs.getInt("idtecido"));
                tecido.setNome(rs.getString("nome"));
                tecido.setVendido(rs.getFloat("vendido"));
                tecido.acrescentaTecido(rs.getFloat("disponivel"));
                tecido.setId_fornecedor(rs.getInt("id_fonecedor"));
                tecido.setId_loja(rs.getInt("id_loja"));
               tecidos.add(tecido);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return tecidos.get(0);
        
    }
    
     public Tecido SelecioneTecidoNome(String nome){
        ArrayList<Tecido>tecidos = new ArrayList<>();
        Tecido tecido;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from tecido where nome=?");
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               tecido = new Tecido();
                tecido.setId(rs.getInt("idtecido"));
                tecido.setNome(rs.getString("nome"));
                tecido.setVendido(rs.getFloat("vendido"));
                tecido.acrescentaTecido(rs.getFloat("disponivel"));
                tecido.setId_fornecedor(rs.getInt("id_fonecedor"));
                tecido.setId_loja(rs.getInt("id_loja"));
               tecidos.add(tecido);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return tecidos.get(0);
        
    }
}
