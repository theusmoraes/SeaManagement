/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Costureiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class CostureiroDAO {
    Conexao conexao;

    public CostureiroDAO() {
        conexao = new Conexao();
    }
     // funcionario(idfuncionario,cpf,nome,usuario,senha,salario,horarioTrabalho,minutosTrabalhados,id_loja) values (1,12345678910,"julio","julio","123456",800,5,60,1);
    public ArrayList<Costureiro> listaTecido(){
        ArrayList<Costureiro>costureiros = new ArrayList<>();
        Costureiro costureiro;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from funcionario");
            ResultSet rs = stmt.executeQuery();
             
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
    public void insereCostureiro(int idfuncionario,float cpf,String nome,String usuario,String senha, float salario, float horarioTrabalho,float minutosTrabalhados){
        String registro = null;
        try{
            String sql= "INSERT INTO funcionario VALUES (?,?,?,?,?,?,?,?,1);";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1,idfuncionario);
            stmt.setFloat(2, cpf);
            stmt.setString(3, nome);
            stmt.setString(4,usuario);
            stmt.setString(5,senha);
            stmt.setFloat(6,salario);
            stmt.setFloat(7,horarioTrabalho);
            stmt.setFloat(8,minutosTrabalhados);
            stmt.execute();
            stmt.close();
            con.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public void editarCostureiro(int idfuncionario,float cpf,String nome,String usuario,String senha, float salario, float horarioTrabalho,float minutosTrabalhados){
        try{
            String sql = "update funcionario set cpf=?,nome=?, usuario=?,senha=?,salario=? ,horarioTrabalho=? ,minutosTrabalhados=? where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setFloat(1,cpf);
            ps.setString(2, nome);
            ps.setString(3,usuario);
            ps.setString(4, senha);
            ps.setFloat(5, salario);
            ps.setFloat(6, horarioTrabalho);
            ps.setFloat(7, minutosTrabalhados);
            ps.setFloat(8, idfuncionario);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro:"+e.getMessage());
            
        }
    }
     public void eliminarCostureiro(int id){
        try{
            String sql = "delete funcionario where id=?";
            Connection conexaobd = conexao.getConnection();
            PreparedStatement ps = (PreparedStatement) conexaobd.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro:"+e.getMessage());
        }
    }
     public Costureiro loginCostureiro(String usuario,String senha){
       ArrayList<Costureiro>costureiros = new ArrayList<>();
        Costureiro costureiro;
        
        
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from funcionario where usuario=? and senha=?");
            stmt.setString(1,usuario);
            stmt.setString(2, senha);
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
        } 
        if( costureiros.get(0).getUsuario().equals(usuario) && costureiros.get(0).getSenha().equals(senha)){
            return costureiros.get(0);
        }else{
          return null;  
        }
    }
    
}
