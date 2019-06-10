
package Model;

public class Costureiro extends Empregado{
    
    public void comissao(float vendas) {
       if (vendas >= 500){  
           this.salario *= 1.2;
       }else{
           this.salario *= 1.2;
        }
    }
}
