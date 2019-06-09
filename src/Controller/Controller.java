
package Controller;

import Dao.AdmDAO;
import Dao.CostureiroDAO;
import Model.Adiministrador;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import View.*;
import Model.Costureiro;
import Model.Empregado;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Geral
 */
public class Controller implements ActionListener, KeyListener {
     Login login = new Login();
     Costureiro costureiro = new Costureiro();
     TelaAdimin tela = new TelaAdimin();
     CadastroUsuario cadastro = new CadastroUsuario();
     Adiministrador adm = new Adiministrador();
     AdmDAO admdao= new AdmDAO();
      Costureiro cos =new Costureiro();
      CostureiroDAO cosDAO =new CostureiroDAO();
     ArrayList<Adiministrador>adms = new ArrayList<>();
    public Controller (Login loginCrud, Costureiro costureiro){
        this.costureiro = costureiro;
        this.login = loginCrud;
        this.login.btnUser.addActionListener(this);
        this.login.BtnSenha.addActionListener(this);
        this.login.brnEntrar.addActionListener(this);
        this.login.setResizable(false);



        
        
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == login.brnEntrar){
           
           String senha = login.BtnSenha.getText();
           String usuario = login.btnUser.getText();
           login.setVisible(false);
           this.tela.btnCadastro.addActionListener(this);
           this.tela.btnPerfil.addActionListener(this);
           this.tela.btnHistorico.addActionListener(this);
           tela.setVisible(true);
       }
       if (e.getSource() == tela.btnCadastro){
           this.tela.setVisible(false);
           this.cadastro.btnCadastrar.addActionListener(this);
           this.cadastro.passConfirma.addActionListener(this);
           this.cadastro.passSenha.addActionListener(this);
           this.cadastro.txtCpf.addActionListener(this);
           this.cadastro.txtHorario.addActionListener(this);
           this.cadastro.txtNome.addActionListener(this);
           this.cadastro.txtSalario.addActionListener(this);
           this.cadastro.txtUser.addActionListener(this);
           this.cadastro.cxAdmin.addActionListener(this);
           this.cadastro.setVisible(true);
       }
       if (e.getSource() == cadastro.btnCadastrar){
           String senha = cadastro.passSenha.getText();
           String confirma = cadastro.passConfirma.getText();
           String user = cadastro.txtUser.getText();
           String salario = cadastro.txtSalario.getText();
           String nome = cadastro.txtNome.getText();
           String cpf = cadastro.txtCpf.getText();
           String horario = cadastro.txtHorario.getText();
           if (senha.equals(confirma)){
               if (cadastro.cxAdmin.isSelected()){
                //JOGA CADA COISA PARA O METODO "AdminDao"

                admdao.insereAdm(2, Float.parseFloat(cpf), nome, user, senha, Float.parseFloat(salario), Float.parseFloat(horario));
                   System.out.println("a");

               }else{
                //JOGA CADA COISA PARA O METODO "CostureiroDAO"
                cosDAO.insereCostureiro(2, Float.parseFloat(cpf), nome, user, senha, Float.parseFloat(salario), Float.parseFloat(horario),1);
               }
                cadastro.setVisible(false);
                tela.setVisible(true);
               
           }
           
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
