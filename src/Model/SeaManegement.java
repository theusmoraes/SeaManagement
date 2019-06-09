
package Model;

import Controller.Controller;
import Dao.AdmDAO;
import View.*;
public class SeaManegement {

    public static void main(String[] args) {
        Login log = new Login();
        log.setVisible(true);
        Costureiro cost = new Costureiro();
        Controller control = new Controller(log, cost);
       log.setVisible(true);
       log.setLocationRelativeTo(null);
        
  
       
    }
    
}
