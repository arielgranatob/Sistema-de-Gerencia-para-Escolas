package escola;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameMatricula extends javax.swing.JFrame {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public JFrameMatricula() {
        initComponents();
        carregarDados();
        this.setLocationRelativeTo(null);
    }

    void createMatricula() {

        if (tabelaCurso.getSelectedRowCount() == 0 || tabelaAluno.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um ALUNO e um CURSO para realizar a na MATRÍCULA", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                ps = Persistencia.conexao().prepareStatement("INSERT INTO matricula (idAluno, idCurso) VALUES (?,?)");
                ps.setString(1, tabelaAluno.getModel().getValueAt(tabelaCurso.getSelectedRow(), 0).toString());
                ps.setString(2, tabelaCurso.getModel().getValueAt(tabelaCurso.getSelectedRow(), 0).toString());
                ps.executeUpdate();
                carregarDados();
            } catch (SQLException e) {
                System.out.println("Erro no INSERT " + e);
            }
        }
    }

    void carregarDados() {

        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM matricula");
            rs = ps.executeQuery();

            DefaultTableModel dtm = new DefaultTableModel(new String[]{"ID Matricula", "ID Aluno", "ID Curso"}, 0);

            while (rs.next()) {
                String dados[] = {rs.getString("idMatricula"), rs.getString("idAluno"), rs.getString("idCurso")};
                dtm.addRow(dados);
            }
            tabelaMatricula.setModel(dtm);
        } catch (SQLException e) {
            System.out.println("Erro no SELECT da Matricula: " + e);
        }

        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso");
            rs = ps.executeQuery();

            DefaultTableModel dtm = new DefaultTableModel(new String[]{"ID", "Nome"}, 0);

            while (rs.next()) {
                String dados[] = {rs.getString("idCurso"), rs.getString("nomeCurso")};
                dtm.addRow(dados);
            }
            tabelaCurso.setModel(dtm);
        } catch (SQLException e) {
            System.out.println("Erro no SELECT do Curso: " + e);
        }

        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM aluno");
            rs = ps.executeQuery();

            DefaultTableModel dtm = new DefaultTableModel(new String[]{"ID", "Nome", "CPF"}, 0);

            while (rs.next()) {
                String dados[] = {rs.getString("idAluno"), rs.getString("nomeAluno"), rs.getString("cpfAluno")};
                dtm.addRow(dados);
            }
            tabelaAluno.setModel(dtm);
        } catch (SQLException e) {
            System.out.println("Erro no SELECT do Aluno: " + e);
        }
    }

    void deleteMatricula() {
        try {
            if (tabelaMatricula.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                ps = Persistencia.conexao().prepareStatement("DELETE FROM matricula WHERE idMatricula=?");
                ps.setString(1, tabelaMatricula.getModel().getValueAt(tabelaMatricula.getSelectedRow(), 0).toString());
                ps.executeUpdate();
                carregarDados();
            }
        } catch (SQLException e) {
            System.out.println("Erro no DELETE da Matricula" + e);
        }
    }

    void updateMatricula() {
        try {
            if (tabelaMatricula.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Selecione uma MATRÍCULA para alterar", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                ps = Persistencia.conexao().prepareStatement("UPDATE matricula SET idAluno=?, idCurso=? WHERE idMatricula=?");
                ps.setString(1, JOptionPane.showInputDialog("Novo ID do Aluno"));
                ps.setString(2, JOptionPane.showInputDialog("Novo ID do Curso"));
                ps.setString(3, tabelaMatricula.getModel().getValueAt(tabelaMatricula.getSelectedRow(), 0).toString());
                ps.executeUpdate();
                carregarDados();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro, possivelmente o ID do aluno ou do curso está errado" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCurso = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAluno = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaMatricula = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabelaCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaCurso);

        jButton2.setText("Apagar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelaAluno);

        tabelaMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tabelaMatricula);

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addComponent(jButton2))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(71, 71, 71)
                                .addComponent(jButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createMatricula();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        deleteMatricula();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        updateMatricula();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFrameEscola myFrameEscola = new JFrameEscola();
        this.setVisible(false);
        myFrameEscola.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaAluno;
    private javax.swing.JTable tabelaCurso;
    private javax.swing.JTable tabelaMatricula;
    // End of variables declaration//GEN-END:variables
}
