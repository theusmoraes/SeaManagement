
package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import View.*;
import Model.Costureiro;
import Model.Empregado;
import java.awt.Color;
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
     Cadastro cadastroR = new Cadastro();

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
           this.tela.btnCadastroResto.addActionListener(this);
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
                   System.out.println("a");

               }else{
                //JOGA CADA COISA PARA O METODO "CostureiroDAO"
               }
                cadastro.setVisible(false);
                tela.setVisible(true);
               
           }
           
       }
       if (e.getSource() == tela.btnCadastroResto){
           tela.setVisible(false);
           cadastroR.setVisible(true);
           this.cadastroR.btnConfirmaOpcoes.addActionListener(this);
           this.cadastroR.btnAdicionar.addActionListener(this);           
           this.cadastroR.btnSalvar.addActionListener(this);
           this.cadastroR.jcCadastros.addActionListener(this);
           this.cadastroR.jcTecidos.addActionListener(this);
           this.cadastroR.txtNome.addActionListener(this);
           this.cadastroR.txtQuantTecido.addActionListener(this);
           this.cadastroR.txtSegundo.addActionListener(this);
           this.cadastroR.txtTerceiro.addActionListener(this);
           
           this.cadastroR.btnAdicionar.setVisible(false);
           this.cadastroR.btnSalvar.setVisible(false);
           this.cadastroR.jcTecidos.setVisible(false);
           this.cadastroR.tttAdicionarTecidos.setVisible(false);
           this.cadastroR.tttNome.setVisible(false);
           this.cadastroR.tttQuantidadeComprado.setVisible(false);
           this.cadastroR.tttRegistroTecido1.setVisible(false);
           this.cadastroR.tttSegundo.setVisible(false);
           this.cadastroR.tttTerceiro.setVisible(false);
           this.cadastroR.txtNome.setVisible(false);
           this.cadastroR.txtQuantTecido.setVisible(false);
           this.cadastroR.txtSegundo.setVisible(false);
           this.cadastroR.txtTerceiro.setVisible(false);
       }
       if (e.getSource() == cadastroR.btnConfirmaOpcoes ){
           System.out.println(cadastroR.jcCadastros.getSelectedItem());
           if (cadastroR.jcCadastros.getSelectedItem().equals("Tecido")){
               System.out.println("cheguei");
               cadastroR.tttAdicionarTecidos.setVisible(true);
               cadastroR.tttRegistroTecido1.setVisible(true);
               cadastroR.txtNome.setVisible(true);
               cadastroR.tttNome.setVisible(true);
               cadastroR.tttQuantidadeComprado.setVisible(true);
               cadastroR.txtQuantTecido.setVisible(true);
               cadastroR.jcTecidos.setVisible(true);
               
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
