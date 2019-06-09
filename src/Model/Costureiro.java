
package Model;

public class Costureiro extends Empregado{
    private float minutosTrabalhados;

    public float getMinutosTrabalhados() {
        return minutosTrabalhados;
    }

    public void setMinutosTrabalhados(float minutosTrabalhados) {
        this.minutosTrabalhados = minutosTrabalhados;
    }
     
    public void comissao(float vendas) {
       if (vendas >= 500){  
           this.salario *= 1.2;
       }else{
           this.salario *= 1.2;
        }
    }
}
