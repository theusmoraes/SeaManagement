/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Geral
 */
public class Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro2
     */
    public Cadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jcCadastros = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tttTerceiro = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtQuantTecido = new javax.swing.JTextField();
        tttQuantidadeComprado = new javax.swing.JLabel();
        tttSegundo = new javax.swing.JLabel();
        txtTerceiro = new javax.swing.JTextField();
        jcTecidos = new javax.swing.JComboBox();
        tttAdicionarTecidos = new javax.swing.JLabel();
        tttRegistroTecido1 = new javax.swing.JLabel();
        tttNome = new javax.swing.JLabel();
        txtSegundo = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnConfirmaOpcoes = new javax.swing.JButton();
        telaVoltarCada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabel6.setBackground(new java.awt.Color(237, 223, 196));
        jlabel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jlabel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1171, 659, -1, -1));
        jlabel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 463, -1, -1));
        jlabel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1171, 283, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        jlabel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, -1, 144));
        jlabel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 295, 185, -1));

        jPanel6.setBackground(new java.awt.Color(54, 31, 37));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(237, 223, 196));
        jLabel3.setText("Cadastros");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jlabel6.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 920, 130));

        jcCadastros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione uma das opções de cadastro>", "Fornecedor", "Produto", "Tecido", "Maquina" }));
        jcCadastros.setToolTipText("");
        jlabel6.add(jcCadastros, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 240, 30));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jlabel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 380, -1));

        tttTerceiro.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        tttTerceiro.setForeground(new java.awt.Color(54, 31, 37));
        tttTerceiro.setText("Dia Manutenção");
        jlabel6.add(tttTerceiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 250, 30));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel6.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 210, 30));

        txtQuantTecido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel6.add(txtQuantTecido, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 210, 30));

        tttQuantidadeComprado.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        tttQuantidadeComprado.setForeground(new java.awt.Color(54, 31, 37));
        tttQuantidadeComprado.setText("Quantidade Comprado");
        jlabel6.add(tttQuantidadeComprado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 250, 30));

        tttSegundo.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        tttSegundo.setForeground(new java.awt.Color(54, 31, 37));
        tttSegundo.setText("Descrição");
        jlabel6.add(tttSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 250, 30));

        txtTerceiro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel6.add(txtTerceiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 210, 30));

        jcTecidos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione uma das opções de tecidos>" }));
        jcTecidos.setToolTipText("");
        jlabel6.add(jcTecidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 240, 30));

        tttAdicionarTecidos.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        tttAdicionarTecidos.setForeground(new java.awt.Color(54, 31, 37));
        tttAdicionarTecidos.setText("Adicionar Tecidos");
        jlabel6.add(tttAdicionarTecidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 340, 30));

        tttRegistroTecido1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        tttRegistroTecido1.setForeground(new java.awt.Color(54, 31, 37));
        tttRegistroTecido1.setText("Cadastrar Tecidos");
        jlabel6.add(tttRegistroTecido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 300, 30));

        tttNome.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        tttNome.setForeground(new java.awt.Color(54, 31, 37));
        tttNome.setText("Nome");
        jlabel6.add(tttNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 250, 30));

        txtSegundo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel6.add(txtSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 210, 30));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jlabel6.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 120, 30));

        btnAdicionar.setText("Adicionar");
        jlabel6.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 120, 30));

        btnConfirmaOpcoes.setText("Confirmar");
        btnConfirmaOpcoes.setActionCommand("");
        jlabel6.add(btnConfirmaOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        telaVoltarCada.setText("Voltar");
        jlabel6.add(telaVoltarCada, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 882, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cadastro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdicionar;
    public javax.swing.JButton btnConfirmaOpcoes;
    public javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JComboBox jcCadastros;
    public javax.swing.JComboBox jcTecidos;
    private javax.swing.JPanel jlabel6;
    public javax.swing.JButton telaVoltarCada;
    public javax.swing.JLabel tttAdicionarTecidos;
    public javax.swing.JLabel tttNome;
    public javax.swing.JLabel tttQuantidadeComprado;
    public javax.swing.JLabel tttRegistroTecido1;
    public javax.swing.JLabel tttSegundo;
    public javax.swing.JLabel tttTerceiro;
    public javax.swing.JTextField txtNome;
    public javax.swing.JTextField txtQuantTecido;
    public javax.swing.JTextField txtSegundo;
    public javax.swing.JTextField txtTerceiro;
    // End of variables declaration//GEN-END:variables
}
