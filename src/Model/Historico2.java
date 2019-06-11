/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.CostureiroDAO;
import Dao.HistoricoDeUsoDAO;
import Dao.MaquinaDAO;
import Dao.NotafiscalDAO;
import Dao.ProdutoDAO;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class Historico2 {
    
    public ArrayList<HistoricoDeUso>historicoMaquinaFunci(){
        ArrayList<HistoricoDeUso>historico = new ArrayList<>();
        ArrayList<Maquina>Maquinas = new ArrayList<>();
        ArrayList<Costureiro>costureiros = new ArrayList<>();
        HistoricoDeUso his = new HistoricoDeUso();
        HistoricoDeUsoDAO hisdao = new HistoricoDeUsoDAO();
        Maquina mec = new Maquina();
        MaquinaDAO mecdao = new MaquinaDAO();
        ProdutoDAO prodao= new ProdutoDAO();
        Produto produto = new Produto();
        CostureiroDAO cosdao = new CostureiroDAO();
        Costureiro costureiro = new Costureiro(); 
        
               
        Maquinas=mecdao.listaMaquina();
        costureiros=cosdao.listaTecido();
        historico=hisdao.listaHistoricoDeUso();
        
         for (int i = 0; i < historico.size(); i++) {
             for (int j = 0; j < costureiros.size(); j++) {
                 
             if(historico.get(i).getId_costureiro()==costureiros.get(j).getId()){
                 costureiro = new Costureiro();
                 costureiro.setNome(costureiros.get(j).getNome());
                 costureiro.setCpf(costureiros.get(j).getCpf());
                 costureiro.setHorarioTrabalho(costureiros.get(j).getHorarioTrabalho());
                 costureiro.setId(costureiros.get(j).getId());
                 costureiro.setSalario(costureiros.get(j).getSalario());
                 costureiro.setSenha(costureiros.get(j).getSenha());
                 costureiro.setUsuario(costureiros.get(j).getUsuario());
                historico.get(i).setCostureiro(costureiro);
                 
             }
                 
             }
            
             
         }
         for (int i = 0; i < historico.size(); i++) {
             for (int j = 0; j < Maquinas.size(); j++) {
                 
             if(historico.get(i).getId_maquina()==Maquinas.get(j).getIdmaquina()){
                 mec = new Maquina();
                 
                  mec.setIdmaquina(Maquinas.get(j).getIdmaquina());
                  mec.setDescricao(Maquinas.get(j).getDescricao());
                  mec.setDiaManuntencao(Maquinas.get(j).getDiaManuntencao());
                  mec.setNome(Maquinas.get(j).getNome());
                historico.get(i).setMaquina(mec);
                 
             }
                 
             }
            
             
         }
         return historico;
        
        
               
               
               
         
         
     }
    
}
