
package Model;
import View.Perfil;

public class Costureiro extends Empregado{
    
    public void comissao(float vendas) {
       if (vendas >= 500){  
           this.salario *= 1.2;
       }else{
           this.salario *= 1.2;
        }
        
    }
    public void InsereNomePerfil (Perfil perfil,Costureiro costureiro){
        perfil.txtNome.setText(nome);
        perfil.txtCPF.setText(cpf);
        perfil.txtHora.setText(Float.toString(horarioTrabalho));
        perfil.txtSalario.setText(Float.toString(salario));
    }
}
