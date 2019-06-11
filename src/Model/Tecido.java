
package Model;

public class Tecido {
     private int id;
    private int id_fornecedor;
    private int id_loja;
    private String nome;
    private float disponivel;
    private float vendido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }
    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
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

    public void acrescentaTecido(double novo) {
        this.disponivel += novo;
    }
    public void decrescentaTecido(double novo){
        this.disponivel -= novo;
    }

    public void setVendido(float vendido) {
        this.vendido += vendido;
        this.decrescentaTecido(vendido);
    }
  
  
}
