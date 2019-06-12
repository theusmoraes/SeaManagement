
package Controller;

import Dao.AdmDAO;
import Dao.CostureiroDAO;
import Model.Adiministrador;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Dao.*;
import View.*;
import Model.*;
import Dao.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Geral
 */
public class Controller implements ActionListener, KeyListener {
     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
     Perfil perfil = new Perfil();
     TecidoDAO tecidoDAO = new TecidoDAO();
     FornecedorDAO fornecedorDAO = new FornecedorDAO();
     MaquinaDAO maquinaDAO = new MaquinaDAO();
     ProdutoDAO produtoDAO =new ProdutoDAO();
     HistoricoDeUsoDAO historicoDAO = new HistoricoDeUsoDAO();
     TelaEmpregado empregadoBasico = new TelaEmpregado();
     TelaEmpregadoRegistro empRegistro = new TelaEmpregadoRegistro();
     Login login = new Login();
     Costureiro costureiro = new Costureiro();
     TelaAdimin tela = new TelaAdimin();
     CadastroUsuario cadastro = new CadastroUsuario();
     Cadastro cadastroR = new Cadastro();
     Adiministrador adm = new Adiministrador();
     AdmDAO admdao= new AdmDAO();
     Costureiro cos =new Costureiro();
     CostureiroDAO cosDAO =new CostureiroDAO();
     ArrayList<Adiministrador>adms = new ArrayList<>();
     Adiministrador subAdm;
     Costureiro subCos;
     Notafiscal notafiscal=new Notafiscal();
     NotafiscalDAO notafiscalDAO=new NotafiscalDAO();
     ArrayList<Notafiscal>notasfiscal = new ArrayList<>();
     AdmHistorico his = new AdmHistorico();
     AdmRelatorio relatorio = new AdmRelatorio();
     TelaNota telaNota =new TelaNota();
    public Controller (Login loginCrud, Costureiro costureiro){
        this.costureiro = costureiro;
        this.login = loginCrud;
        this.login.btnUser.addActionListener(this);
        this.login.BtnSenha.addActionListener(this);
        this.login.brnEntrar.addActionListener(this);
        this.login.setResizable(false);
        



           }
    public void preencheTabela(JTable tabela){
        DefaultTableModel tabelinha = new DefaultTableModel();
        tabelinha.addColumn("Id");
        tabelinha.addColumn("Nome");
        tabelinha.addColumn("Nick");
        Object [] coluna  = new Object[3];
        int numRegistros = tecidoDAO.listaTecido().size();
        for(int i = 0; i<numRegistros; i++){
            coluna [0] = tecidoDAO.listaTecido().get(i).getId();
            coluna [1] = tecidoDAO.listaTecido().get(i).getNome();
            coluna [1] = tecidoDAO.listaTecido().get(i).getDisponivel();
            tabelinha.addRow(coluna);
        }
        tabela.setModel(tabelinha);

    }
     public void prencherListaProdutos (JComboBox box){
        int numProdutos = produtoDAO.listaProduto().size();
        int i;
        box.removeAllItems();
        for (i=0;i<numProdutos;i++){
            box.addItem(produtoDAO.listaProduto().get(i).getNome());
        }
     }
    public void prencherListaTecidos (JComboBox box){
        int numTecidos = tecidoDAO.listaTecido().size();
        int i;
        box.removeAllItems();
        for (i=0;i<numTecidos;i++){
            box.addItem(tecidoDAO.listaTecido().get(i).getNome());
        }
            
 
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == login.brnEntrar){
           e.setSource(null);
           String senha = login.BtnSenha.getText();
           String usuario = login.btnUser.getText();
           Adiministrador subAdm = new Adiministrador();
           Costureiro subCos = new Costureiro();
           subAdm= admdao.loginAdm(usuario, senha);
           subCos =cosDAO.loginCostureiro(usuario, senha);
           if (subAdm != null) {
            login.setVisible(false);
            tela.setVisible(true); 
            this.tela.btnCadastro.addActionListener(this);
            this.tela.btnPerfil.addActionListener(this);
            this.tela.btnHistorico.addActionListener(this);
            this.tela.btnCadastroResto.addActionListener(this);
            this.tela.telaVoltarAdm.addActionListener(this);
           }else{
               if (subCos != null){
                 empregadoBasico.btnPerfil.addActionListener(this);
                 empregadoBasico.btnRegistro.addActionListener(this);
                 empregadoBasico.telaEmpregadoSair.addActionListener(this);
                 empregadoBasico.vendas12.addActionListener(this);
                 login.setVisible(false);
                 subCos.InsereNomePerfil(perfil, subCos);
                 empregadoBasico.setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null,"Senha ou Usuario errado","Erro de login",JOptionPane.ERROR_MESSAGE);
               }
           }
           
       }
       if (e.getSource() == tela.btnCadastro){
           this.tela.setVisible(false);
           this.cadastro.btnCadastrar.addActionListener(this);
           this.cadastro.passConfirma.addActionListener(this);
           this.cadastro.passSenha.addActionListener(this);
           this.cadastro.txtCpf.addActionListener(this);
           this.cadastro.txtHorario.addActionListener(this);
           this.cadastro.txtNome.addActionListener(this);
           this.cadastro.txtSalario.addActionListener(this);
           this.cadastro.txtUser.addActionListener(this);
           this.cadastro.cxAdmin.addActionListener(this);
           this.cadastro.setVisible(true);
           this.cadastro.telaCadastraUsuario.addActionListener(this);
           e.setSource(null);
       }
        if (e.getSource() == tela.btnPerfil) {
            tela.setVisible(false);
            dataset.setValue(50, "", "Janeiro");
            dataset.setValue(60, "", "Fevereiro");
            dataset.setValue(40, "", "Março");
            dataset.setValue(90, "", "Abril");
            /*JFreeChart chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.HORIZONTAL,false,false,false);
            CategoryPlot catPlot = chart.getCategoryPlot();
            catPlot.setRangeGridlinePaint(Color.BLACK);*/
            
            JFreeChart chart = ChartFactory.createLineChart("Teste grafico", "Mes", "Vendas", dataset,
                    PlotOrientation.VERTICAL, true,true,false);
            ChartPanel chartPanel = new ChartPanel(chart);
            relatorio.jGrafico.removeAll();
            relatorio.jGrafico.add(chartPanel,BorderLayout.CENTER);
            relatorio.jGrafico.validate();
            relatorio.setVisible(true);
            relatorio.telaRelatorio.addActionListener(this);

            
        }
       
       if (e.getSource() == cadastro.btnCadastrar){
           String senha = cadastro.passSenha.getText();
           String confirma = cadastro.passConfirma.getText();
           String user = cadastro.txtUser.getText();
           String salario = cadastro.txtSalario.getText();
           String nome = cadastro.txtNome.getText();
           String cpf = cadastro.txtCpf.getText();
           String horario = cadastro.txtHorario.getText();
           e.setSource(null);
           if (senha.equals(confirma)){
               if (cadastro.cxAdmin.isSelected()){
                //JOGA CADA COISA PARA O METODO "AdminDao"

                admdao.insereAdm( Float.parseFloat(cpf), nome, user, senha, Float.parseFloat(salario), Float.parseFloat(horario));

               }else{
                //JOGA CADA COISA PARA O METODO "CostureiroDAO"
                cosDAO.insereCostureiro( Float.parseFloat(cpf), nome, user, senha, Float.parseFloat(salario), Float.parseFloat(horario));
               }
                cadastro.setVisible(false);
                tela.setVisible(true);
               
           }
           
       }
       
       if (e.getSource() == tela.btnCadastroResto){
           tela.setVisible(false);
           cadastroR.setVisible(true);
           this.cadastroR.btnConfirmaOpcoes.addActionListener(this);
           this.cadastroR.btnAdicionar.addActionListener(this);           
           this.cadastroR.btnSalvar.addActionListener(this);
           this.cadastroR.jcCadastros.addActionListener(this);
           this.cadastroR.jcTecidos.addActionListener(this);
           this.cadastroR.txtNome.addActionListener(this);
           this.cadastroR.txtQuantTecido.addActionListener(this);
           this.cadastroR.txtSegundo.addActionListener(this);
           this.cadastroR.txtTerceiro.addActionListener(this);
           this.cadastroR.jcCadastros.setVisible(true);
           this.cadastroR.btnConfirmaOpcoes.setVisible(true);
           this.cadastroR.btnAdicionar.setVisible(false);
           this.cadastroR.btnSalvar.setVisible(false);
           this.cadastroR.jcTecidos.setVisible(false);
           this.cadastroR.tttAdicionarTecidos.setVisible(false);
           this.cadastroR.tttNome.setVisible(false);
           this.cadastroR.tttQuantidadeComprado.setVisible(false);
           this.cadastroR.tttRegistroTecido1.setVisible(false);
           this.cadastroR.tttSegundo.setVisible(false);
           this.cadastroR.tttTerceiro.setVisible(false);
           this.cadastroR.txtNome.setVisible(false);
           this.cadastroR.txtQuantTecido.setVisible(false);
           this.cadastroR.txtSegundo.setVisible(false);
           this.cadastroR.txtTerceiro.setVisible(false);
           this.cadastroR.telaVoltarCada.addActionListener(this);
            e.setSource(null);

       }
        /*if (e.getSource() == tela.btnHistorico) {
            tela.setVisible(false);
            his.setVisible(true);
            
        }*/
       if (e.getSource() == cadastroR.btnConfirmaOpcoes ){
           e.setSource(null);
           if (cadastroR.jcCadastros.getSelectedItem().equals("Tecido")){
               prencherListaTecidos(cadastroR.jcTecidos);
               cadastroR.btnConfirmaOpcoes.setVisible(false);
               cadastroR.jcCadastros.setVisible(false);
               cadastroR.tttAdicionarTecidos.setVisible(true);
               cadastroR.tttRegistroTecido1.setVisible(true);
               cadastroR.txtNome.setVisible(true);
               cadastroR.tttNome.setVisible(true);
               cadastroR.tttQuantidadeComprado.setVisible(true);
               cadastroR.txtQuantTecido.setVisible(true);
               cadastroR.jcTecidos.setVisible(true);
               cadastroR.btnAdicionar.setVisible(true);
               cadastroR.btnSalvar.setVisible(true);
               cadastroR.tttSegundo.setVisible(true);
               cadastroR.txtSegundo.setVisible(true);
               cadastroR.tttSegundo.setText("Id Fornecedor");
               cadastroR.tttTerceiro.setVisible(false);
               cadastroR.txtTerceiro.setVisible(false);
           }else{
                if (cadastroR.jcCadastros.getSelectedItem().equals("Fornecedor")){
                    cadastroR.btnSalvar.setVisible(true);
                     cadastroR.btnConfirmaOpcoes.setVisible(false);
                     cadastroR.jcCadastros.setVisible(false);
                     cadastroR.tttNome.setVisible(true);
                     cadastroR.tttSegundo.setVisible(true);
                     cadastroR.tttSegundo.setText("Id Fornecedor");
                     cadastroR.txtSegundo.setVisible(true);
                     cadastroR.txtNome.setVisible(true);
                     cadastroR.tttRegistroTecido1.setVisible(true);
                     cadastroR.tttRegistroTecido1.setText("Cadastrar Fornecedor");
                }else{
                  if (cadastroR.jcCadastros.getSelectedItem().equals("Maquina")){
                     cadastroR.btnConfirmaOpcoes.setVisible(false);
                     cadastroR.jcCadastros.setVisible(false);
                     cadastroR.tttRegistroTecido1.setVisible(true);
                     cadastroR.tttRegistroTecido1.setVisible(true);
                     cadastroR.tttRegistroTecido1.setText("Cadastrar Tecido");
                     cadastroR.tttNome.setVisible(true);
                     cadastroR.tttSegundo.setVisible(true);
                     cadastroR.tttTerceiro.setVisible(true);
                     cadastroR.txtNome.setVisible(true);
                     cadastroR.txtSegundo.setVisible(true);
                     cadastroR.txtTerceiro.setVisible(true);
                     cadastroR.btnSalvar.setVisible(true);
                     cadastroR.tttSegundo.setText("Descrição");
                     cadastroR.tttTerceiro.setText("Dia manutenção");
                    
                }else{
                    if (cadastroR.jcCadastros.getSelectedItem().equals("Produto")){
                     cadastroR.btnConfirmaOpcoes.setVisible(false);
                     cadastroR.jcCadastros.setVisible(false);
                     prencherListaTecidos(cadastroR.jcTecidos);

                     cadastroR.tttQuantidadeComprado.setVisible(true);
                     cadastroR.txtQuantTecido.setVisible(true);
                     cadastroR.jcTecidos.setVisible(true);
                     cadastroR.tttQuantidadeComprado.setText("Quantidade (kg):");
                     cadastroR.tttAdicionarTecidos.setVisible(true);
                     cadastroR.tttAdicionarTecidos.setText("Tecido pára fabricar a peça");
                     
                     cadastroR.tttNome.setVisible(true);
                     cadastroR.txtNome.setVisible(true);
                     cadastroR.tttRegistroTecido1.setVisible(true);
                     cadastroR.tttSegundo.setVisible(true);
                     cadastroR.txtSegundo.setVisible(true);
                     cadastroR.txtTerceiro.setVisible(true);
                     cadastroR.tttTerceiro.setVisible(true);
                     cadastroR.btnSalvar.setVisible(true);
                     cadastroR.tttTerceiro.setVisible(true);
                     cadastroR.tttRegistroTecido1.setText("Registrar novo Produto");
                     cadastroR.tttTerceiro.setText("tipo do Produto");
                     cadastroR.tttSegundo.setText("preço");
                    }else{
                        JOptionPane.showMessageDialog(null,"Escolha uma opção valida");
                    }
                  }  
               }       
           }
       }     
       if (e.getSource() == cadastroR.btnSalvar){
           e.setSource(null);
           if (cadastroR.jcCadastros.getSelectedItem().equals("Tecido")){
               String nome = cadastroR.txtNome.getText();
               int id_fornecedor = Integer.parseInt(cadastroR.txtSegundo.getText());
               TecidoDAO tecidoDAO = new TecidoDAO();
               tecidoDAO.insereTecido(nome,0, id_fornecedor);
               
               
           }else{
               if (cadastroR.jcCadastros.getSelectedItem().equals("Fornecedor")){
                   String nome = cadastroR.txtNome.getText();
                   String id_fornecedor = cadastroR.txtSegundo.getText();
                   fornecedorDAO.insereFornecedor(nome);
                  
               }else{
                if (cadastroR.jcCadastros.getSelectedItem().equals("Maquina")){
                     String nome = cadastroR.txtNome.getText();
                     String descricao = cadastroR.txtSegundo.getText();
                     String manutencao = cadastroR.txtTerceiro.getText();
                     maquinaDAO.insereMaquina(nome, descricao, manutencao);
                       
                   }else{
                        String nome = cadastroR.txtNome.getText();
                        float preco = Float.parseFloat(cadastroR.txtSegundo.getText());
                        String tipoProduto = cadastroR.txtTerceiro.getText();
                        String tipoTecido = (String) cadastroR.jcTecidos.getSelectedItem();
                        int usadaquant = Integer.parseInt(cadastroR.txtQuantTecido.getText());
                         //int idProduto = produtoDAO.SelecioneIdProduto(nome);
                         int idProduto = tecidoDAO.SelecioneTecidoNomeRetornaId(tipoTecido);
                        produtoDAO.insereProduto(nome, preco, tipoProduto, idProduto, usadaquant);
                        
//                        produtoDAO.insereProduto(nome, preco, TipoProduto, id_tecido, usadaquant);
                        
                }
               }
           }
           cadastroR.setVisible(false);
           tela.setVisible(true);
       }
       if (e.getSource() == tela.btnHistorico){
           tela.setVisible(false);
           his.setVisible(true);
           his.setSize (900,660);
           this.his.jButtonHistoricodevendas.addActionListener(this);
           this.his.vendatop.addActionListener(this);
           this.his.telaVoltarHistorico.addActionListener(this);
          
         
            e.setSource(null);
            
                
       }
       if (e.getSource() == his.jButtonHistoricodevendas){
                ArrayList<HistoricoDeUso>historics = new ArrayList<>();
                Historico2 his =new Historico2();
                historics=his.historicoMaquinaFunci();
                
                String vamos="\n Informacoes sobre o uso da maquina";
                String vamos2;
        for (int i = 0; i < historics.size(); i++) {
            
                vamos2="\nid: "+historics.get(i).getIdHistoricodeuso()+"\nmaquina: "+historics.get(i).getMaquina().getNome()+"\nfuncionario: "+historics.get(i).getCostureiro().getNome()+"";
            
            vamos= vamos.concat(vamos2);
        }
               
     // String s = "Strings are immutable";
     // s = s.concat(" all the time");
        JOptionPane.showMessageDialog(null,vamos);
     // System.out.println(vamos);
                e.setSource(null);
       }
       if (e.getSource() == his.vendatop){
                ArrayList<Notafiscal>note = new ArrayList<>();
                Nota2 not =new Nota2();
                note=not.notaFiscalComcostureiroeProduto();
                
                String jay="\n Informacoes sobre as vendas\n";
                String jay2;
        for (int i = 0; i < note.size(); i++) {
            
                jay2="\nid: "+note.get(i).getIdnotafiscal()+"\nmaquina: "+note.get(i).getProduto().getNome()+"\nfuncionario: "+note.get(i).getFuncionario().getNome()+"\n mes: "+note.get(i).getMes()+"";
            
            jay= jay.concat(jay2);
        }
               
     // String s = "Strings are immutable";
     // s = s.concat(" all the time");
        JOptionPane.showMessageDialog(null,jay);
     // System.out.println(vamos);
                e.setSource(null);
       }
       if (e.getSource() == cadastroR.btnAdicionar){
           String nome_tecido = (String) cadastroR.jcTecidos.getSelectedItem();
         int quantidade_tecido = Integer.parseInt(cadastroR.txtQuantTecido.getText());
         Tecido tecronaldo =new    Tecido();
         TecidoDAO tecronaldodao = new TecidoDAO();
         tecronaldo = tecronaldodao.SelecioneTecidoNome(nome_tecido);
        tecronaldo.acrescentaTecido(quantidade_tecido);
        tecronaldodao.editarTecidoPassandoTecido(tecronaldo);
         cadastroR.setVisible(false);
         tela.setVisible(true);

           
       }
       if (e.getSource() == empregadoBasico.btnPerfil){
           e.setSource(null);
           System.out.println(perfil.nome);
        
           empregadoBasico.setVisible(false);
           perfil.setVisible(true);
           perfil.telaPerfilVoltar.addActionListener(this);
       }
       if (e.getSource() == perfil.telaPerfilVoltar){
           e.setSource(null);
           
            perfil.setVisible(false);
           empregadoBasico.setVisible(true);
           
           
       }
       if (e.getSource() == empregadoBasico.btnRegistro){
           
           empregadoBasico.setVisible(false);
           empRegistro.btnSalvar.addActionListener(this);
           empRegistro.jcProduto.addActionListener(this);
           prencherListaProdutos(empRegistro.jcProduto);
           empRegistro.txHorarioInicio.addActionListener(this);
           empRegistro.txtHorarioFim.addActionListener(this);
           empRegistro.txtIdMaquina.addActionListener(this);
           empRegistro.txtID.addActionListener(this);
           
           empRegistro.setVisible(true);
           empRegistro.telaEmpregadoRegistroVoltar.addActionListener(this);
          
       }
       if (e.getSource() == empregadoBasico.vendas12){
           
           e.setSource(null);
           
            
           empregadoBasico.setVisible(false);
           telaNota.setVisible(true);
           telaNota.jTextIdEMPREGADO1EMRE.addActionListener(this);
           telaNota.jTextIdEMPREGADOMES.addActionListener(this);
           telaNota.jTextIdEMPREGADOPROD.addActionListener(this);
           telaNota.telaNota.addActionListener(this);
           
           
       }
       if (e.getSource() == empRegistro.telaEmpregadoRegistroVoltar){
           e.setSource(null);
           
            empRegistro.setVisible(false);
           empregadoBasico.setVisible(true);
           
           
       }
       if (e.getSource() == empregadoBasico.telaEmpregadoSair){
           e.setSource(null);
           
            
           empregadoBasico.setVisible(false);
           login.setVisible(true);
           
           
       }
       if (e.getSource() == cadastro.telaCadastraUsuario){
           e.setSource(null);
           
            
           cadastro.setVisible(false);
           tela.setVisible(true);
           
           
       }
       if (e.getSource() == cadastroR.telaVoltarCada){
           e.setSource(null);
           
            
           cadastroR.setVisible(false);
           tela.setVisible(true);
           
           
       }
       if (e.getSource() == his.telaVoltarHistorico){
           e.setSource(null);
           
            
           his.setVisible(false);
           tela.setVisible(true);
           
           
       }
       if (e.getSource() == tela.telaVoltarAdm){
           e.setSource(null);
           
            
           tela.setVisible(false);
           login.setVisible(true);
           
           
       }
       if (e.getSource() == relatorio.telaRelatorio){
           e.setSource(null);
           
            
           relatorio.setVisible(false);
           tela.setVisible(true);
           
           
       }
       
       if (e.getSource() == empRegistro.btnSalvar){
          String horarioIncio = empRegistro.txHorarioInicio.getText();
          String horarioFim = (empRegistro.txtHorarioFim.getText());
          int idMaquina = Integer.parseInt(empRegistro.txtIdMaquina.getText());
          int idUsuario = Integer.parseInt(empRegistro.txtID.getText());
          historicoDAO.insereHistorico(horarioIncio, horarioFim, idMaquina, idUsuario);
          
          
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
