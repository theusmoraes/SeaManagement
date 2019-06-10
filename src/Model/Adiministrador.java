
package Model;

import java.util.ArrayList;

public class Adiministrador extends Empregado{
    
    private ArrayList <Costureiro> surpevisao;

    public ArrayList<Costureiro> getSurpevisao() {
        return surpevisao;
    }

    public void setSurpevisao(ArrayList<Costureiro> surpevisao) {
        this.surpevisao = surpevisao;
    }
    
    public Adiministrador(){
        surpevisao = new ArrayList();
    }
    
    public void cadastraumfuniSurpevisao (Costureiro costureiro){
        surpevisao.add(costureiro);
    }
}
