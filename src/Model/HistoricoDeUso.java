
package Model;

public class HistoricoDeUso {
    private String horaInicio;
    private String horaFinal;
    private Maquina maquina;
    private Costureiro costureiro;

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public Costureiro getCostureiro() {
        return costureiro;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public void setCostureiro(Costureiro costureiro) {
        this.costureiro = costureiro;
    }
    
}
