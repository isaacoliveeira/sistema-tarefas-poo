package com.mycompany.gerenciadordetarefas.view;


import com.mycompany.gerenciadordetarefas.controller.TarefaController;
import com.mycompany.gerenciadordetarefas.controller.TarefaRepository;
import com.mycompany.gerenciadordetarefas.model.Tarefa;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.gerenciadordetarefas.view.TelaLogin.usuarioLogado;

public class TelaPrincipal extends javax.swing.JFrame {
    TarefaRepository tarefaPersistence = new TarefaRepository();
    TarefaController tarefaController = new TarefaController();
    private List<Tarefa> tarefas;
    private final JFrame frame;

    public TelaPrincipal() {
        initComponents();
        this.tarefas = new ArrayList<>();
        this.frame =  new JFrame("Sistema tarefas");
        try {
            jButtonListarTarefa1ActionPerformed(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButtonCriarTarefa = new javax.swing.JButton();
        jButtonEditarTarefa = new javax.swing.JButton();
        jButtonRemoverTarefa = new javax.swing.JButton();
        jTextFieldBuscarTarefa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButtonRemoverTarefa1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList1.setModel(new AbstractListModel<Tarefa>() {
           Tarefa[] strings = {};

            public int getSize() {
                return strings.length;
            }

            public Tarefa getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonCriarTarefa.setText("Criar Tarefa");
        jButtonCriarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarTarefaActionPerformed(evt);
            }
        });

        jButtonEditarTarefa.setText("Editar Tarefa");
        jButtonEditarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonEditarTarefaActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButtonRemoverTarefa.setText("Remover Tarefa");
        jButtonRemoverTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonRemoverTarefaActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jTextFieldBuscarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jTextFieldBuscarTarefaActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel1.setText("Buscar Tarefa");

        jButton2.setText("Buscar");

        jButtonRemoverTarefa1.setText("Atualizar Tarefas");
        jButtonRemoverTarefa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonListarTarefa1ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButtonRemoverTarefa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonCriarTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonEditarTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonRemoverTarefa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldBuscarTarefa))
                                                .addGap(20, 20, 20))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addGap(41, 41, 41))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jButtonCriarTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditarTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverTarefa1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBuscarTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(36, 36, 36)
                                .addComponent(jButton1)
                                .addContainerGap())
        );

        setSize(new java.awt.Dimension(585, 330));
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }


    private void jButtonEditarTarefaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        int selectedIndex = jList1.getSelectedIndex();
    
        if (selectedIndex != -1) {
            Tarefa tarefaSelecionada = obterTarefaSelecionada(selectedIndex);
    
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja editar a tarefa?", "Confirmação", JOptionPane.YES_NO_OPTION);
    
            if (opcao == JOptionPane.YES_OPTION) {
                TelaEdicaoTarefa telaEdicao = new TelaEdicaoTarefa(this, true, tarefaSelecionada);
                telaEdicao.setVisible(true);
    
                atualizarListaTarefas(TarefaRepository.carregarTarefas(usuarioLogado));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    private Tarefa obterTarefaSelecionada(int selectedIndex) {
        DefaultListModel<Tarefa> model = (DefaultListModel<Tarefa>) jList1.getModel();

        if (selectedIndex >= 0 && selectedIndex < model.size()) {
            return model.getElementAt(selectedIndex);
        }
        JOptionPane.showMessageDialog(frame, "Nenhuma tarefa foi selecionada");
        return null;
    }


    void atualizarListaTarefas(List<Tarefa> tarefas) {
        jList1.setListData(tarefas.toArray(new Tarefa[0]));
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            jTextFieldBuscarTarefaActionPerformed(evt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    


    private void jButtonRemoverTarefaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        int selectedIndex = jList1.getSelectedIndex();
    
        if (selectedIndex != -1) {
            Tarefa selectedTask = obterTarefaSelecionada(selectedIndex);
    
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover a tarefa?", "Confirmação", JOptionPane.YES_NO_OPTION);
    
            if (opcao == JOptionPane.YES_OPTION) {
                ListModel<Tarefa> model = jList1.getModel();
    
                if (selectedIndex < model.getSize()) {
                    if (model instanceof DefaultListModel) {
                        DefaultListModel<Tarefa> defaultListModel = (DefaultListModel<Tarefa>) model;
    
                        defaultListModel.remove(selectedIndex);
                        tarefaController.removerTarefa(usuarioLogado, selectedTask.getTitulo());
                        tarefas.remove(selectedTask); // Remova a tarefa da lista local também
                    } else {
                        JOptionPane.showMessageDialog(frame, "Não foi possível remover a tarefa");
                    }
                }
            }
        }
    }
    
    

    private void jTextFieldBuscarTarefaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        String termoBusca = jTextFieldBuscarTarefa.getText();
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
    }
    });

    jButtonRemoverTarefa1.setText("Atualizar Tarefas");
    jButtonRemoverTarefa1.addActionListener(new java.awt.event.ActionListener() {

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
            jButtonListarTarefa1ActionPerformed(evt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    });

        if (termoBusca != null && !termoBusca.isEmpty()) {
            List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuarioLogado);

            if (tarefas != null) {
                DefaultListModel<Tarefa> model = new DefaultListModel<>();
                for (Tarefa tarefa : tarefas) {
                    if (tarefa.getDescricao().contains(termoBusca) || tarefa.getTitulo().contains(termoBusca)) {
                        model.addElement(tarefa);
                    }
                }
                jList1.setModel(model);
            } else {
                JOptionPane.showMessageDialog(frame, "Nenhuma tarefa foi encontrada");
            }
        }
    }



    private void jButtonCriarTarefaActionPerformed(java.awt.event.ActionEvent evt) {
        InterfaceTarefa telaCadastro = new InterfaceTarefa(tarefaController);
        telaCadastro.setVisible(true);
    }

    private void jButtonListarTarefa1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuarioLogado);

        if (tarefas != null) {
            DefaultListModel<Tarefa> model = new DefaultListModel<>();
            for (Tarefa tarefa : tarefas) {
                model.addElement(tarefa);
            }
            jList1.setModel(model);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhuma tarefa para listar");
        }
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCriarTarefa;
    private javax.swing.JButton jButtonEditarTarefa;
    private javax.swing.JButton jButtonRemoverTarefa;
    private javax.swing.JButton jButtonRemoverTarefa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Tarefa> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldBuscarTarefa;

}