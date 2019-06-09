
package Model;

public abstract class Empregado {
    protected String nome;
    protected String cpf;
    protected String usuario;
    protected String senha;
    protected float salario;
    protected float horarioTrabalho;

    public float getSalario() {
        return salario;
    }

    public float getHorarioTrabalho() {
        return horarioTrabalho;
    }

    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setHorarioTrabalho(float horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


        
    
    
    
}
