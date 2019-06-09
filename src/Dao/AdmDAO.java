/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Adiministrador;
import Model.Costureiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class AdmDAO {
    Conexao conexao;

    public AdmDAO() {
        conexao = new Conexao();
    }
    //insert into adm (idadm,cpf,nome,usuario,senha,salario,horarioTrabalho,id_loja)values (10123456789,"ronaldo","ron","1234",1000,10,1);
    //insert into supervisao(idsupervisao,id_adm,id_funcionario) values (1,1);
    //aqui
    public ArrayList<Adiministrador> listaAdm(){
        ArrayList<Adiministrador>adms = new ArrayList<>();
        Adiministrador adm;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from adm");
            ResultSet rs = stmt.executeQuery();
             
           while(rs.next()){
               adm = new Adiministrador();
               adm.setId(rs.getInt("idfuncionario"));
               adm.setCpf(rs.getString("cpf"));
                adm.setNome(rs.getString("nome"));
                adm.setUsuario(rs.getString("usuario"));
                adm.setSenha(rs.getString("senha"));
                adm.setSalario(rs.getFloat("salario"));
                adm.setHorarioTrabalho(rs.getFloat("horarioTrabalho"));
               adms.add(adm);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return adms;
        
    }
    public void insereAdm(int id,float cpf,String nome,String usuario,String senha, float salario, float horarioTrabalho){
        String registro = null;
        try{
            String sql= "INSERT INTO adm VALUES (?,?,?,?,?,?,?,1);";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setFloat(2, cpf);
            stmt.setString(3, nome);
            stmt.setString(4,usuario);
            stmt.setString(5,senha);
            stmt.setFloat(6,salario);
            stmt.setFloat(7,horarioTrabalho);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarAdm(int id,float cpf,String nome,String usuario,String senha, float salario, float horarioTrabalho){
        try{
            String sql = "update adm set cpf=?,nome=?, usuario=?,senha=?,salario=? ,horarioTrabalho=?  where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setFloat(1,cpf);
            ps.setString(2, nome);
            ps.setString(3,usuario);
            ps.setString(4, senha);
            ps.setFloat(5, salario);
            ps.setFloat(6, horarioTrabalho);
            ps.setFloat(7, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarAdm(int id){
        try{
            String sql = "delete adm where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public Adiministrador loginAdm(String usuario,String senha){
        ArrayList<Adiministrador>adms = new ArrayList<>();
        Adiministrador adm;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from adm where usuario=? and senha=?");
            stmt.setString(1,usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
             if (!rs.isBeforeFirst()){
                
                return null;
             } 
   
           while(rs.next()){
               adm = new Adiministrador();
               adm.setId(rs.getInt("idadm"));
               adm.setCpf(rs.getString("cpf"));
                adm.setNome(rs.getString("nome"));
                adm.setUsuario(rs.getString("usuario"));
                adm.setSenha(rs.getString("senha"));
                adm.setSalario(rs.getFloat("salario"));
                adm.setHorarioTrabalho(rs.getFloat("horarioTrabalho"));
              adms.add(adm);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } 
       
        if( adms.get(0).getUsuario().equals(usuario) && adms.get(0).getSenha().equals(senha)){
            return adms.get(0);
        }else{
            return null;
        }
        
    }
     public ArrayList<Costureiro> superfisaoAdm(int id){
        ArrayList<Costureiro>costureiros = new ArrayList<>();
        Costureiro costureiro;
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select funcionario.* from funcionario ,adm,supervisao where ?=supervisao.id_adm and supervisao.id_funcionario=funcionario.idfuncionario;");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
             if (!rs.isBeforeFirst()){
                
                return null;
             } 
           while(rs.next()){
               costureiro = new Costureiro();
               costureiro.setId(rs.getInt("idfuncionario"));
               costureiro.setCpf(rs.getString("cpf"));
              costureiro.setNome(rs.getString("nome"));
               costureiro.setUsuario(rs.getString("usuario"));
              costureiro.setSenha(rs.getString("senha"));
              costureiro.setSalario(rs.getFloat("salario"));
              costureiro.setHorarioTrabalho(rs.getFloat("horarioTrabalho"));
               costureiro.setMinutosTrabalhados(rs.getFloat("minutosTrabalhados"));
               costureiros.add(costureiro);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return costureiros;
        
    }
     
     
    //insert into supervisao(idsupervisao,id_adm,id_funcionario) values (1,1);
    public void insereSupervisaoAdm(int id,int id_adm,int id_funcionario){
        String registro = null;
        try{
            String sql= "INSERT INTO supervisao VALUES (?,?,?);";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setInt(2,id_adm);
            stmt.setInt(3,id_funcionario);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarSupervisaoAdm(int id,int id_adm,int id_funcionario){
        try{
            String sql = "update supervisao set id_adm=?,id_funcionario=?, where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1,id_adm);
            ps.setInt(2,id_funcionario);
            ps.setFloat(3, id);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarSupervisaoAdm(int id){
        try{
            String sql = "delete supervisao where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public int tamanhoAdm(){
        ArrayList<Adiministrador>adms = new ArrayList<>();
        Adiministrador adm;
        int cont=0;
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from adm");
            ResultSet rs = stmt.executeQuery();
             
           while(rs.next()){
               adm = new Adiministrador();
               adm.setId(rs.getInt("idfuncionario"));
               adm.setCpf(rs.getString("cpf"));
                adm.setNome(rs.getString("nome"));
                adm.setUsuario(rs.getString("usuario"));
                adm.setSenha(rs.getString("senha"));
                adm.setSalario(rs.getFloat("salario"));
                adm.setHorarioTrabalho(rs.getFloat("horarioTrabalho"));
               adms.add(adm);
               cont++;
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return cont;
        
    }
     
}
