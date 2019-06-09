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
                costureiro.setHorarioTrabalho(rs.getFloat("horarioTrabalho"));
                costureiro.setMinutosTrabalhados(rs.getFloat("minutosTrabalhados"));
                
               costureiros.add(costureiro);
              
           }
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } return costureiros;
        
    }
    
}
