
package Model;

public class Costureiro extends Empregado{

    public void setSalario(double salario, double vendas) {
       if (vendas >= 500){  
        this.salario = salario * 1.5 ;
       }else{
           this.salario = salario * 1.2;
        }
    }
}
