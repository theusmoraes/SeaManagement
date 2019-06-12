/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Costureiro;
import Model.HistoricoDeUso;
import Model.Maquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class HistoricoDeUsoDAO {
    Conexao conexao;

    public HistoricoDeUsoDAO() {
        conexao = new Conexao();
    }
    //insert into historicodeuso(idhistoricodeuso,horarioinicial,horariofinal,id_maquina,id_funcionario) values ("9:50","10:10",1,1)
    public ArrayList<HistoricoDeUso> listaHistoricoDeUso(){
        ArrayList<HistoricoDeUso>historicos = new ArrayList<>();
        HistoricoDeUso historico;
        ArrayList<Maquina>maquinas = new ArrayList<>();
        Maquina maquina;
        MaquinaDAO Mac =new MaquinaDAO();
        ArrayList<Costureiro>costureiros = new ArrayList<>();
        Costureiro costureiro;
        CostureiroDAO cosdao = new CostureiroDAO();
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from historicodeuso");
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               historico= new HistoricoDeUso();
                historico.setIdHistoricodeuso(rs.getInt("idHistoricodeuso"));
                historico.setHoraInicio(rs.getString("horarioinicial"));
                historico.setHoraFinal(rs.getString("horariofinal"));
                historico.setId_maquina(rs.getInt("id_maquina"));
                historico.setId_costureiro(rs.getInt("id_funcionario"));
                historico.setId_produto(rs.getInt("id_produto"));
                
             historicos.add(historico);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return historicos;
        
    }
    
    public void insereHistorico(String horarioinicial,String horariofinal, int id_maquina, int id_funcionario, int id_produto){
        String registro = null;
        try{
            String sql= "INSERT INTO historicodeuso(horarioinicial,horariofinal,id_maquina,id_funcionario,id_produto) VALUES (?,?,?,?,?)";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1,horarioinicial);
            stmt.setString(2,horariofinal);
            stmt.setInt(3, id_maquina);
            stmt.setInt(4, id_funcionario);
            stmt.setInt(5, id_produto);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarHistorico(int id ,String horarioinicial,String horariofinal, int id_maquina, int id_funcionario,int id_produto){
        try{
            String sql = "update historicodeuso set horarioinicial=? ,horariofinal =?,id_maquina =?,id_funcionario=? where idHistoricodeuso=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setString(1, horarioinicial);
            ps.setString(2,horariofinal);
            ps.setInt(3, id_maquina);
            ps.setInt(4, id_funcionario);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarHistorico(int id){
        try{
            String sql = "delete from historicodeuso where idHistoricodeuso=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public HistoricoDeUso SelecioneHistorico(int id){
        ArrayList<HistoricoDeUso>historicos = new ArrayList<>();
        HistoricoDeUso historico;
        ArrayList<Maquina>maquinas = new ArrayList<>();
        Maquina maquina;
        MaquinaDAO Mac =new MaquinaDAO();
        ArrayList<Costureiro>costureiros = new ArrayList<>();
        Costureiro costureiro;
        CostureiroDAO cosdao = new CostureiroDAO();
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from historicodeuso where idHistoricodeuso=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
               historico= new HistoricoDeUso();
                historico.setIdHistoricodeuso(rs.getInt("idHistoricodeuso"));
                historico.setHoraInicio(rs.getString("horarioinicial"));
                historico.setHoraFinal(rs.getString("horariofinal"));
              historico.setId_maquina(rs.getInt("id_maquina"));
                historico.setId_costureiro(rs.getInt("id_funcionario"));
                historico.setId_produto(rs.getInt("id_produto"));
             historicos.add(historico);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return historicos.get(0);  
    }
}
