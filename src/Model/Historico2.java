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
        ArrayList<HistoricoDeUso>historics = new ArrayList<>();
        ArrayList<Produto>produtos = new ArrayList<>();
        ArrayList<Costureiro>costureiros = new ArrayList<>();
        Notafiscal nota= new Notafiscal();
        NotafiscalDAO notaDAO= new NotafiscalDAO();
        HistoricoDeUsoDAO hisDAO=new HistoricoDeUsoDAO();
        ProdutoDAO prodao= new ProdutoDAO();
        Produto produto = new Produto();
        CostureiroDAO cosdao = new CostureiroDAO();
        Costureiro costureiro = new Costureiro(); 
        //Produto produto = new Produto();
        Maquina mec = new Maquina ();
        MaquinaDAO mecdao= new MaquinaDAO();
        ArrayList<Maquina>maquinas = new ArrayList<>();
        maquinas=mecdao.listaMaquina();
        costureiros=cosdao.listaTecido();
                historics=hisDAO.listaHistoricoDeUso();

         for (int i = 0; i < historics.size(); i++) {
             for (int j = 0; j < costureiros.size(); j++) {
                 
             if(historics.get(i).getId_costureiro()==costureiros.get(j).getId()){
                 costureiro = new Costureiro();
                 costureiro.setNome(costureiros.get(j).getNome());
                 costureiro.setCpf(costureiros.get(j).getCpf());
                 costureiro.setHorarioTrabalho(costureiros.get(j).getHorarioTrabalho());
                 costureiro.setId(costureiros.get(j).getId());
                 costureiro.setSalario(costureiros.get(j).getSalario());
                 costureiro.setSenha(costureiros.get(j).getSenha());
                 costureiro.setUsuario(costureiros.get(j).getUsuario());
                historics.get(i).setCostureiro(costureiro);
                 
             }
                 
             }
            
             
         }
         for (int i = 0; i < historics.size(); i++) {
             for (int j = 0; j < maquinas.size(); j++) {
                 
             if(historics.get(i).getId_maquina()==maquinas.get(j).getIdmaquina()){
                 Maquina mec2 = new Maquina();
                 mec2.setNome(maquinas.get(j).getNome());
                 mec2.setDescricao(maquinas.get(j).getDescricao());
                 mec2.setDiaManuntencao(maquinas.get(j).getDiaManuntencao());
                 mec2.setIdmaquina(maquinas.get(j).getIdmaquina());
                historics.get(i).setMaquina(mec2);
                 
                  //mec.setIdmaquina(Maquinas.get(j).getIdmaquina());
                //  mec.setDescricao(Maquinas.get(j).getDescricao());
                  //mec.setDiaManuntencao(Maquinas.get(j).getDiaManuntencao());
                 // mec.setNome(Maquinas.get(j).getNome());
               // historico.get(i).setMaquina(mec);
                  
                 
             }
                 
             }
            
             
         }
         return historics;
        
        
               
               
               
         
         
     }
    
}
