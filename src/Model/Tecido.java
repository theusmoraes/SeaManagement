
package Model;

public class Tecido {
  private String nome;
  private double disponivel;
  private double vendido;

public Tecido(){
    this.disponivel = 0;
    this.vendido = 0;
}
    public String getNome() {
        return nome;
    }

    public double getDisponivel() {
        return disponivel;
    }

    public double getVendido() {
        return vendido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void acrescentaTecido(double disponivel) {
        this.disponivel += disponivel;
    }
    public void decrescentaTecido(double disponivel){
        this.disponivel -= disponivel;
    }

    public void setVendido(double vendido) {
        this.vendido += vendido;
        this.decrescentaTecido(vendido);
    }
  
  
}
