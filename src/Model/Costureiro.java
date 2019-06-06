
package Model;

public class Costureiro extends Empregado{
    private float minutosTrabalhados;

    public float getMinutosTrabalhados() {
        return minutosTrabalhados;
    }

    public void setMinutosTrabalhados(float minutosTrabalhados) {
        this.minutosTrabalhados = minutosTrabalhados;
    }
     
    public void comissao(double vendas) {
       if (vendas >= 500){  
        this.salario = salario * 1.5 ;
       }else{
           this.salario = salario * 1.2;
        }
    }
}
