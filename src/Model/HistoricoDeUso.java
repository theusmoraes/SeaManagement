
package Model;

public class HistoricoDeUso {
    private int idHistoricodeuso;
    private String horaInicio;
    private String horaFinal;
    private Maquina maquina;
    private Costureiro costureiro;
    private int id_produto;
    private  int id_maquina;
    private  int id_costureiro;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public int getId_costureiro() {
        return id_costureiro;
    }

    public void setId_costureiro(int id_costureiro) {
        this.id_costureiro = id_costureiro;
    }
    
    public int getIdHistoricodeuso() {
        return idHistoricodeuso;
    }

    public void setIdHistoricodeuso(int idHistoricodeuso) {
        this.idHistoricodeuso = idHistoricodeuso;
    }
    

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
