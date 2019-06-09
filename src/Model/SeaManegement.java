
package Model;

import Controller.Controller;
import View.*;
public class SeaManegement {

    public static void main(String[] args) {
        Login log = new Login();
        log.setVisible(true);
        Costureiro cost = new Costureiro();
        Controller control = new Controller(log, cost);
        log.setVisible(true);
        log.setLocationRelativeTo(null);
                                  
        /*TelaAdimin tela = new TelaAdimin();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);*/
        

    }
    
}
