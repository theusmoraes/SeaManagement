/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Fornecedor;
import Model.Maquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class MaquinaDAO {
    Conexao conexao;

    public MaquinaDAO() {
    conexao = new Conexao();
    }
    //insert into maquina(idmaquina,nome,descricao,diamanutencao) values (1,"overloque","Pode ser usada tanto para roupas delicadas como lingeries e tecidos pesados como os de tapetes.","dia 5 do mes");
    public ArrayList<Maquina> listaMaquina(){
        ArrayList<Maquina>maquinas = new ArrayList<>();
        Maquina maquina;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from maquina");
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               maquina= new Maquina();
                maquina.setIdmaquina(rs.getInt("idmaquina"));
                maquina.setNome(rs.getString("nome"));
                maquina.setDescricao(rs.getString("descricao"));
                maquina.setDiaManuntencao(rs.getString("diamanutencao"));
               maquinas.add(maquina);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return maquinas;
        
    }
     public int SelecioneMaquinaNomeRetornaId(String nome){
        ArrayList<Maquina>maquinas = new ArrayList<>();
        Maquina maquina;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from maquina where nome=?");
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               maquina = new Maquina();
                maquina.setIdmaquina(rs.getInt("idmaquina"));
                maquina.setNome(rs.getString("nome"));
                maquina.setDiaManuntencao(rs.getString("diamanutencao"));
                maquina.setDescricao(rs.getString("descricao"));
                
               maquinas.add(maquina);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return maquinas.get(0).getIdmaquina();
        
    }
    
    public void insereMaquina(String nome, String descricao, String diamanutencao){
        String registro = null;
        try{
            String sql= "INSERT INTO maquina (nome,descricao,diamanutencao)VALUES (?,?,?)";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2,descricao);
            stmt.setString(3, diamanutencao);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarMaquina(int id ,String nome, String descricao, String diamanutencao){
        try{
            String sql = "update maquina set nome=? ,descricao =?,diamanutencao =? where idmaquina=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2,descricao);
            ps.setString(3,diamanutencao);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarMaquina(int id){
        try{
            String sql = "delete from maquina where idmaquina=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public Maquina SelecioneMaquina(int id){
        ArrayList<Maquina>maquinas = new ArrayList<>();
        Maquina maquina;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from maquina where idmaquina=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               maquina = new Maquina();
               maquina.setIdmaquina(rs.getInt("idmaquina"));
               maquina.setNome(rs.getString("nome"));
               maquina.setDescricao(rs.getString("descricao"));
               maquina.setDiaManuntencao(rs.getString("diamanutencao"));
               maquinas.add(maquina);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return maquinas.get(0);
        
    }
}
