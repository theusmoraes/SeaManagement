
package Model;

public class Tecido {
     private int id;
    private int idse;
    private int idsa;
    private String nome;
    private float disponivel;
    private float vendido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdse() {
        return idse;
    }

    public void setIdse(int idse) {
        this.idse = idse;
    }

    public int getIdsa() {
        return idsa;
    }

    public void setIdsa(int idsa) {
        this.idsa = idsa;
    }


public Tecido(){
    this.disponivel = 0;
    this.vendido = 0;
}
    public String getNome() {
        return nome;
    }

    public float getDisponivel() {
        return disponivel;
    }

    public float getVendido() {
        return vendido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void acrescentaTecido(Float disponivel) {
        this.disponivel += disponivel;
    }
    public void decrescentaTecido(Float disponivel){
        this.disponivel -= disponivel;
    }

    public void setVendido(float vendido) {
        this.vendido += vendido;
        this.decrescentaTecido(vendido);
    }
  
  
}
