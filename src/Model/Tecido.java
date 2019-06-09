
package Model;

public class Tecido {
  private String nome;
  private float disponivel;
  private float vendido;

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

    public void acrescentaTecido(float disponivel) {
        this.disponivel += disponivel;
    }
    public void decrescentaTecido(float disponivel){
        this.disponivel -= disponivel;
    }

    public void setVendido(float vendido) {
        this.vendido += vendido;
        this.decrescentaTecido(vendido);
    }
  
  
}
