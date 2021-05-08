/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author acaro
 */
public class InterfaceJukebox extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public InterfaceJukebox() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backColor = new javax.swing.JPanel();
        abas = new javax.swing.JTabbedPane();
        abaConversao = new javax.swing.JPanel();
        textoDigite = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        caixaTexto = new javax.swing.JTextArea();
        bConverter = new javax.swing.JButton();
        textoConfiguracoes = new javax.swing.JLabel();
        textoInstrumento = new javax.swing.JLabel();
        textoBpm = new javax.swing.JLabel();
        selInstrumento = new javax.swing.JComboBox<>();
        selBpm = new javax.swing.JComboBox<>();
        textoDownload = new javax.swing.JLabel();
        bDownload = new javax.swing.JButton();
        bSelecionar = new javax.swing.JButton();
        textoSelecione = new javax.swing.JLabel();
        caixaNome = new javax.swing.JTextField();
        textoNome = new javax.swing.JLabel();
        textoMid = new javax.swing.JLabel();
        textoVolume = new javax.swing.JLabel();
        textoOitava = new javax.swing.JLabel();
        selVolume = new javax.swing.JComboBox<>();
        selOitava = new javax.swing.JComboBox<>();
        abaHelp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMapeamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TEXTO MUSICAL ♪ - Converte seu texto em uma música!");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        backColor.setBackground(new java.awt.Color(174, 179, 197));

        abas.setBackground(new java.awt.Color(0, 0, 0));
        abas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        abaConversao.setBackground(new java.awt.Color(102, 102, 102));
        abaConversao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textoDigite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDigite.setForeground(new java.awt.Color(204, 204, 204));
        textoDigite.setText("Digite aqui o texto a ser convertido:");

        caixaTexto.setBackground(new java.awt.Color(174, 179, 197));
        caixaTexto.setColumns(20);
        caixaTexto.setRows(5);
        caixaTexto.setBorder(null);
        caixaTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(caixaTexto);

        bConverter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bConverter.setText("Converter");
        bConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConverterActionPerformed(evt);
            }
        });

        textoConfiguracoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoConfiguracoes.setForeground(new java.awt.Color(204, 204, 204));
        textoConfiguracoes.setText("Configurações iniciais:");

        textoInstrumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textoInstrumento.setForeground(new java.awt.Color(204, 204, 204));
        textoInstrumento.setText("Instrumento:");

        textoBpm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textoBpm.setForeground(new java.awt.Color(204, 204, 204));
        textoBpm.setText("BPM:");

        selInstrumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selInstrumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piano", "Violão", "Guitarra", "Violino", "Agogo", "Orquestra", "Flauta de Pã", "Órgão", "Sinos tubulares", "Cravo" }));

        selBpm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selBpm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "40", "70", "100", "130", "160", "190", "220" }));
        selBpm.setSelectedIndex(2);

        textoDownload.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDownload.setForeground(new java.awt.Color(204, 204, 204));
        textoDownload.setText("Faça o download da sua música:");

        bDownload.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bDownload.setText("Download");
        bDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDownloadActionPerformed(evt);
            }
        });

        bSelecionar.setText("Selecionar");
        bSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelecionarActionPerformed(evt);
            }
        });

        textoSelecione.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoSelecione.setForeground(new java.awt.Color(204, 204, 204));
        textoSelecione.setText("Ou selecione o arquivo a ser convertido:");

        caixaNome.setBackground(new java.awt.Color(174, 179, 197));

        textoNome.setForeground(new java.awt.Color(204, 204, 204));
        textoNome.setText("Nome do arquivo:");

        textoMid.setForeground(new java.awt.Color(204, 204, 204));
        textoMid.setText(".MID");

        textoVolume.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textoVolume.setForeground(new java.awt.Color(204, 204, 204));
        textoVolume.setText("Volume:");

        textoOitava.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textoOitava.setForeground(new java.awt.Color(204, 204, 204));
        textoOitava.setText("Oitava:");

        selVolume.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selVolume.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        selVolume.setSelectedIndex(2);

        selOitava.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selOitava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selOitava.setSelectedIndex(5);

        javax.swing.GroupLayout abaConversaoLayout = new javax.swing.GroupLayout(abaConversao);
        abaConversao.setLayout(abaConversaoLayout);
        abaConversaoLayout.setHorizontalGroup(
            abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaConversaoLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(textoInstrumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoOitava)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selOitava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoBpm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selBpm, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoVolume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(abaConversaoLayout.createSequentialGroup()
                .addGroup(abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaConversaoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDigite)
                            .addComponent(textoConfiguracoes)
                            .addComponent(textoSelecione)))
                    .addGroup(abaConversaoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(abaConversaoLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(abaConversaoLayout.createSequentialGroup()
                                .addComponent(bSelecionar)
                                .addGap(157, 157, 157)
                                .addComponent(bConverter))
                            .addGroup(abaConversaoLayout.createSequentialGroup()
                                .addComponent(textoNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caixaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoMid)
                                .addGap(60, 60, 60)
                                .addComponent(bDownload))))
                    .addGroup(abaConversaoLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(textoDownload)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abaConversaoLayout.setVerticalGroup(
            abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaConversaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoConfiguracoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoInstrumento)
                    .addComponent(textoOitava)
                    .addComponent(selOitava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBpm)
                    .addComponent(selBpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoVolume)
                    .addComponent(selVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(textoDigite)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(textoSelecione)
                .addGap(18, 18, 18)
                .addGroup(abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSelecionar)
                    .addComponent(bConverter))
                .addGap(30, 30, 30)
                .addComponent(textoDownload)
                .addGap(18, 18, 18)
                .addGroup(abaConversaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDownload)
                    .addComponent(caixaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNome)
                    .addComponent(textoMid))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        abas.addTab("Conversão", abaConversao);

        abaHelp.setBackground(new java.awt.Color(102, 102, 102));

        tabMapeamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A", "Nota Lá"},
                {"B", "Nota Si"},
                {"C", "Nota Dó"},
                {"D", "Nota Ré"},
                {"E", "Nota Mi"},
                {"F", "Nota Fá"},
                {"G", "Nota Sol"},
                {"@", "Nota aleatória"},
                {"Espaço", "Dobra o volume (se não puder, volta volume inicial)"},
                {"?", "Aumenta uma oitava (se não puder, volta oitava inicial)"},
                {"%", "Diminui uma oitava (se não puder, volta oitava inicial)"},
                {"+", "+50 BPM (máx 310)"},
                {"-", "-50 BPM (min 60)"},
                {"!", "Troca instrumento para Agogo"},
                {"#", "Troca instrumento para Guitarra"},
                {"$", "Troca instrumento para Orquestra"},
                {"; (ponto e vírgula)", "Troca instrumento para Pan Flute"},
                {", (vírgula)", "Troca instrumento para Church Organ"},
                {"Quebra de linha (\\n)", "Troca instrumento para Tubular Bells"},
                {"Vogais (I,i,O,o,U,u)", "Troca instrumento para Harpsichord"},
                {"Número", "Trocar instrumento para instrumento ATUAL + valor do dígito"},
                {"ELSE", "Se caractere anterior era NOTA (A até G), repete nota"},
                {null, "Caso contrário, pausa "}
            },
            new String [] {
                "Texto", "Ação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabMapeamento.setShowGrid(true);
        jScrollPane2.setViewportView(tabMapeamento);
        if (tabMapeamento.getColumnModel().getColumnCount() > 0) {
            tabMapeamento.getColumnModel().getColumn(0).setResizable(false);
            tabMapeamento.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabMapeamento.getColumnModel().getColumn(1).setResizable(false);
            tabMapeamento.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        javax.swing.GroupLayout abaHelpLayout = new javax.swing.GroupLayout(abaHelp);
        abaHelp.setLayout(abaHelpLayout);
        abaHelpLayout.setHorizontalGroup(
            abaHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );
        abaHelpLayout.setVerticalGroup(
            abaHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        abas.addTab("Help", abaHelp);

        javax.swing.GroupLayout backColorLayout = new javax.swing.GroupLayout(backColor);
        backColor.setLayout(backColorLayout);
        backColorLayout.setHorizontalGroup(
            backColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas)
        );
        backColorLayout.setVerticalGroup(
            backColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bConverterActionPerformed(java.awt.event.ActionEvent evt)  {//GEN-FIRST:event_bConverterActionPerformed

        // TODO add your handling code here:
        if(caixaTexto.getText().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Insira o texto a ser convertida", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        else {
            InterpretadorDeTexto interpretador = new InterpretadorDeTexto();
            interpretador.defineTextoInput(caixaTexto.getText());
            interpretador.defineConfiguracoesIniciais(selBpm.getSelectedItem().toString(), selInstrumento.getSelectedItem().toString(),
                    selVolume.getSelectedItem().toString(), selOitava.getSelectedItem().toString());
            String textoMusical = interpretador.geraTextoParametrizado();

            TocadorDeMusica jukebox = new TocadorDeMusica();
            jukebox.defineStaccato(textoMusical);
            jukebox.tocaMusica();
        }

    }//GEN-LAST:event_bConverterActionPerformed

    private void bSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelecionarActionPerformed
        // TODO add your handling code here:
        //jButton3.addActionListener(new ActionListener() {
            //@Override
            //public void actionPerformed(ActionEvent e)  {
                escolheArquivo txt = new escolheArquivo();
                caixaTexto.setText(txt.escolhe());

            //}
        //});
    }//GEN-LAST:event_bSelecionarActionPerformed

    private void bDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDownloadActionPerformed
        // TODO add your handling code here:
        if(caixaTexto.getText().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Insira o texto a ser convertida", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        else {
            InterpretadorDeTexto interpretador = new InterpretadorDeTexto();
            interpretador.defineTextoInput(caixaTexto.getText());
            interpretador.defineConfiguracoesIniciais(selBpm.getSelectedItem().toString(), selInstrumento.getSelectedItem().toString(),
                    selVolume.getSelectedItem().toString(), selOitava.getSelectedItem().toString());
            String textoMusical = interpretador.geraTextoParametrizado();

            if (caixaNome.getText().isEmpty())
                JOptionPane.showMessageDialog(rootPane, "Insira o nome do arquivo", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            else {
                GravadorDeMusica recorder = new GravadorDeMusica();
                recorder.defineNomeArquivo(caixaNome.getText() + ".mid");
                recorder.gravaMusica(textoMusical);

                JOptionPane.showMessageDialog(rootPane, "Download concluido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_bDownloadActionPerformed
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
            java.util.logging.Logger.getLogger(InterfaceJukebox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceJukebox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceJukebox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceJukebox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceJukebox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaConversao;
    private javax.swing.JPanel abaHelp;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton bConverter;
    private javax.swing.JButton bDownload;
    private javax.swing.JButton bSelecionar;
    private javax.swing.JPanel backColor;
    private javax.swing.JTextField caixaNome;
    private javax.swing.JTextArea caixaTexto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> selBpm;
    private javax.swing.JComboBox<String> selInstrumento;
    private javax.swing.JComboBox<String> selOitava;
    private javax.swing.JComboBox<String> selVolume;
    private javax.swing.JTable tabMapeamento;
    private javax.swing.JLabel textoBpm;
    private javax.swing.JLabel textoConfiguracoes;
    private javax.swing.JLabel textoDigite;
    private javax.swing.JLabel textoDownload;
    private javax.swing.JLabel textoInstrumento;
    private javax.swing.JLabel textoMid;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoOitava;
    private javax.swing.JLabel textoSelecione;
    private javax.swing.JLabel textoVolume;
    // End of variables declaration//GEN-END:variables
}
