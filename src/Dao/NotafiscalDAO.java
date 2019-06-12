/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Costureiro;
import Model.Maquina;
import Model.Notafiscal;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class NotafiscalDAO {
    Conexao conexao;

    public NotafiscalDAO() {
    conexao = new Conexao();
    }
    //insert into notafiscal(idnotafiscal,id_loja,id_produto,id_funcionario) values (1,1,1,1);
public ArrayList<Notafiscal> listaNotafiscal(){
        ArrayList<Notafiscal>notas = new ArrayList<>();
        Notafiscal nota;
        Costureiro costureiro;
        ProdutoDAO prodao= new ProdutoDAO();
        CostureiroDAO cosdao = new CostureiroDAO();
        Produto produto;
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from notafiscal");
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               nota= new Notafiscal();
                nota.setIdnotafiscal(rs.getInt("idnotafiscal"));
                nota.setId_loja(rs.getInt("id_loja"));
                nota.setId_produto(rs.getInt("id_produto"));
                nota.setId_funcionario(rs.getInt("id_funcionario"));
                nota.setMes(rs.getString("mes"));
                
               notas.add(nota);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return notas;
        
    }
    
    public void insereNotas(int id_produto, int id_funcionario,String mes){
        String registro = null;
        try{
            String sql= "INSERT INTO notafiscal(id_loja,id_produto,id_funcionario,mes) VALUES (1,?,?,?)";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, id_produto);
            stmt.setInt(2,id_funcionario);
            stmt.setString(3,mes);
            
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarNotas(int id, int id_produto, int id_funcionario, String mes){
        try{
            String sql = "update notafiscal set id_produto=? ,id_funcionario =? ,mes=? where idnotafiscal=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id_produto);
            ps.setInt(2,id_funcionario);
            ps.setString(3,mes);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarNota(int id){
        try{
            String sql = "delete from notafiscal where idnotafiscal=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public Notafiscal SelecioneNota(int id){
        ArrayList<Notafiscal>notas = new ArrayList<>();
        Notafiscal nota;
        Costureiro costureiro;
        CostureiroDAO cosdao = new CostureiroDAO();
        Produto produto;
        ProdutoDAO prodao= new ProdutoDAO();
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from notafiscal where idnotafiscal=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
                nota= new Notafiscal();
                nota.setIdnotafiscal(rs.getInt("idnotafiscal"));
                nota.setId_loja(rs.getInt("id_loja"));
                nota.setId_produto(rs.getInt("id_produto"));
                nota.setId_funcionario(rs.getInt("id_funcionario"));
                nota.setMes(rs.getString("mes"));
               notas.add(nota);
              
           }
            //foi
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return notas.get(0);
        
    }
     
     
     public Notafiscal Lista(int id){
        ArrayList<Notafiscal>notas = new ArrayList<>();
        Notafiscal nota;
        Costureiro costureiro;
        CostureiroDAO cosdao = new CostureiroDAO();
        Produto produto;
        ProdutoDAO prodao= new ProdutoDAO();
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from notafiscal where idnotafiscal=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
                nota= new Notafiscal();
                nota.setIdnotafiscal(rs.getInt("idnotafiscal"));
                nota.setId_loja(rs.getInt("id_loja"));
                nota.setId_produto(rs.getInt("id_produto"));
                nota.setId_funcionario(rs.getInt("id_funcionario"));
                nota.setMes(rs.getString("mes"));
               notas.add(nota);
              
           }
            //foi
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return notas.get(0);
        
    }
     public ArrayList<Notafiscal> NotasProduto(int id_produto){
        ArrayList<Notafiscal>notas = new ArrayList<>();
        Notafiscal nota;
        Costureiro costureiro;
        CostureiroDAO cosdao = new CostureiroDAO();
        Produto produto;
        ProdutoDAO prodao= new ProdutoDAO();
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from notafiscal where id_produto =?");
            stmt.setInt(1,id_produto);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
                nota= new Notafiscal();
                nota.setIdnotafiscal(rs.getInt("idnotafiscal"));
                nota.setId_loja(rs.getInt("id_loja"));
                nota.setId_produto(rs.getInt("id_produto"));
                nota.setId_funcionario(rs.getInt("id_funcionario"));
                nota.setMes(rs.getString("mes"));
               notas.add(nota);
              
           }
            //foi
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return notas;
        
    }
     public void editarNotasasd(int id, int id_produto, int id_funcionario, String mes){
        try{
            String sql = "update notafiscal set id_produto=? ,id_funcionario =? ,mes=? where idnotafiscal=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id_produto);
            ps.setInt(2,id_funcionario);
            ps.setString(3,mes);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
   
}
