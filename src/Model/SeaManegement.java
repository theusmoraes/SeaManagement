
package Model;

import Controller.Controller;
import Dao.AdmDAO;
import Dao.FornecedorDAO;
import Dao.HistoricoDeUsoDAO;
import Dao.MaquinaDAO;
import Dao.NotafiscalDAO;
import Dao.ProdutoDAO;
import Dao.TecidoDAO;
import View.*;
import java.util.ArrayList;
public class SeaManegement {

    public static void main(String[] args) {
       /* Login log = new Login();
        log.setVisible(true);
        Costureiro cost = new Costureiro();
        Controller control = new Controller(log, cost);
       log.setVisible(true);
       log.setLocationRelativeTo(null);
        */                        
       
       
        
        
        // fornecedor
        ArrayList<Fornecedor>fornecedores = new ArrayList<>();
        FornecedorDAO FORdao =new FornecedorDAO();
        Fornecedor FOR =new Fornecedor();
        
        
        //FORdao.insereFornecedor("marcelo");
        //FORdao.insereFornecedor("JOAO");
        //FORdao.editarFornecedor(2,"vine");
        //FORdao.eliminarFornecedor(2);
        //FOR=FORdao.SelecioneFornecedor(1);
        //fornecedores=FORdao.listaFonecedor();
        //System.out.println("Model.SeaManegement.main()"+fornecedores.get(1).getNome());
        
        
        //historico
         ArrayList<HistoricoDeUso>historicos = new ArrayList<>();
        HistoricoDeUsoDAO historicodao =new HistoricoDeUsoDAO();
        HistoricoDeUso historico =new HistoricoDeUso();
        Historico2 his =new Historico2();
        //historicodao.insereHistorico("8;10", "9;10", 1, 1);
       // historicodao.eliminarHistorico(2);
        historicos=his.historicoMaquinaFunci();
        for (int i = 0; i < historicos.size(); i++) {
            
       System.out.println("Model.SeaManegement.main()"+historicos.get(i).getCostureiro().getNome());
       
       System.out.println("Model.SeaManegement.main()"+historicos.get(i).getMaquina().getNome());
       
       
       
            
        }
        
        // maquina
        ArrayList<Maquina>maquinas = new ArrayList<>();
        MaquinaDAO Macdao =new MaquinaDAO();
        Maquina Mac =new Maquina();
       // Macdao.editarMaquina(2,"l12d", "piu", "dia 1");
       // maquinas=Macdao.listaMaquina();
       // System.out.println("Model.SeaManegement.main()"+maquinas.get(1).getNome());
        
        //nota fiscal
        ArrayList<Notafiscal>notas = new ArrayList<>();
        NotafiscalDAO notafiscaldao= new NotafiscalDAO();
        Notafiscal notafiscal= new Notafiscal();
        //notafiscaldao.editarNotas(1,2, 1);
        //notas=notafiscaldao.listaNotafiscal();
        //System.out.println("Model.SeaManegement.main()"+notas.get(1).getIdnotafiscal());
        //PROduto
        ArrayList<Produto>produtos = new ArrayList<>();
        ProdutoDAO produtodao = new ProdutoDAO();
        Produto produto = new Produto();
       // produtodao.editarProduto(2,"bunda123", 47,"corp234", 1, 20);
        produtos=produtodao.listaProduto();
        //System.out.println("Model.SeaManegement.main()"+produtos.get(1).getNome());
        // TECIDO
        ArrayList<Tecido>tecidos = new ArrayList<>();
        TecidoDAO tecidodao = new TecidoDAO();
        Tecido tecido = new Tecido();
        //tecidodao.editarTecido(2,"al435", 20,3, 1);
        tecidos=tecidodao.listaTecido();
        //System.out.println("Model.SeaManegement.main()"+tecidos.get(1).getNome());
       /* 
       */ 
       // historicodao.eliminarHistorico(2);
       // Macdao.eliminarMaquina(2);
       // notafiscaldao.eliminarNota(1);
        //produtodao.eliminarProduto(2);
       //tecidodao.eliminarTecido(2);
       
    }
    
}
