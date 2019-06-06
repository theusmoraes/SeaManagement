
package Model;

import java.util.ArrayList;

public class Adiministrador extends Empregado{
    
    private ArrayList <Costureiro> surpevisao;
    
    public Adiministrador(){
        surpevisao = new ArrayList();
    }
    
    public void setSurpevisao (Costureiro costureiro){
        surpevisao.add(costureiro);
    }
}
