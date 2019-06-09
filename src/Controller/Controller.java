
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
    public Controller (Login loginCrud, Costureiro costureiro){
        this.costureiro = costureiro;
        this.login = loginCrud;
        this.login.brnEntrar.setBackground(new Color (237,223,196));
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
