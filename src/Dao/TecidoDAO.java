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
                tecido.setIdsa(rs.getInt("id_fonecedor"));
                tecido.setIdse(rs.getInt("id_loja"));
               tecidos.add(tecido);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return tecidos;
        
    }
    
    public void insereTecido(int id ,String nome, float disponivel,float vendido){
        String registro = null;
        try{
            String sql= "INSERT INTO tecido VALUES (?,?,?,?,1,1);";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setString(2, nome);
            stmt.setFloat(3,disponivel);
            stmt.setFloat(4, vendido);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarTecido(int id ,String nome, float disponivel,float vendido){
        try{
            String sql = "update tecido set nome=?, disponivel=?,vendido=? where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setFloat(2,disponivel);
            ps.setFloat(3, vendido);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarTecido(int id){
        try{
            String sql = "delete tecido where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public ArrayList<Tecido> SelecioneTecido(int id,String nome){
        ArrayList<Tecido>tecidos = new ArrayList<>();
        Tecido tecido;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from tecido where idtecido=? and nome =?");
            stmt.setInt(1,id);
            stmt.setString(2, nome);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               tecido = new Tecido();
                tecido.setId(rs.getInt("idtecido"));
                tecido.setNome(rs.getString("nome"));
                tecido.setVendido(rs.getFloat("vendido"));
                tecido.acrescentaTecido(rs.getFloat("disponivel"));
                //tecido.setIdsa(rs.getInt("id_fonecedor"));
                //tecido.setIdse(rs.getInt("id_loja"));
               tecidos.add(tecido);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return tecidos;
        
    }
    
    
}
