
package Model;

public class Empregado {
    private String nome;
    private String cpf;
    private String usuario;
    private String senha;
    private boolean admin;
    private String horarioTrabalho;
    
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

    public boolean isAdmin() {
        return admin;
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

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
        
    
    
    
}
