package com.mycompany.gerenciadordetarefas.view;

import com.mycompany.gerenciadordetarefas.controller.DataInvalidaException;
import com.mycompany.gerenciadordetarefas.controller.DataValidator;
import com.mycompany.gerenciadordetarefas.controller.TarefaController;
import com.mycompany.gerenciadordetarefas.controller.TarefaRepository;
import com.mycompany.gerenciadordetarefas.model.Tarefa;
import com.mycompany.gerenciadordetarefas.model.TarefaService;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.gerenciadordetarefas.view.TelaLogin.usuarioLogado;

public class InterfaceTarefa extends javax.swing.JFrame {

    private final JList<Tarefa> list;
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    private final TarefaController tarefaController;

    private List<Tarefa> tarefas;
    TarefaRepository tarefaPersistence = new TarefaRepository();
    TarefaService tarefaService = new TarefaService(tarefaPersistence);
    public InterfaceTarefa(TarefaController tarefaController) {
        this.tarefaController = tarefaController;
        this.list = new JList<>();
        tarefas = new ArrayList<>();
        initComponents();
        buttonGroup1.add(jRadioButtonNaoConcluida);
        buttonGroup1.add(jRadioButtonConcluida);
        buttonGroup2.add(jRadioButtonBaixa);
        buttonGroup2.add(jRadioButtonMedia);
        buttonGroup2.add(jRadioButtonAlta);
    }



    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButtonNaoConcluida = new javax.swing.JRadioButton();
        jRadioButtonConcluida = new javax.swing.JRadioButton();
        jRadioButtonBaixa = new javax.swing.JRadioButton();
        jRadioButtonMedia = new javax.swing.JRadioButton();
        jRadioButtonAlta = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de cliente ");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Importância");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 190, 120, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Título da tarefa");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 90, 16);

        jTextFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTitulo);
        jTextFieldTitulo.setBounds(10, 28, 240, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Descrição da Tarefa");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 60, 120, 16);

        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });
        getContentPane().add(jFormattedTextFieldData);
        jFormattedTextFieldData.setBounds(20, 210, 64, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Data de Conclusão");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 190, 120, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Status da Tarefa");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 190, 120, 16);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 350, 72, 23);

        jButton2.setText("Concluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 350, 73, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 500, 86);

        jRadioButtonNaoConcluida.setText("Não Concluida");
        getContentPane().add(jRadioButtonNaoConcluida);
        jRadioButtonNaoConcluida.setBounds(180, 210, 110, 21);

        jRadioButtonConcluida.setText("Concluida");
        getContentPane().add(jRadioButtonConcluida);
        jRadioButtonConcluida.setBounds(180, 230, 76, 21);

        jRadioButtonBaixa.setText("Baixa");
        getContentPane().add(jRadioButtonBaixa);
        jRadioButtonBaixa.setBounds(350, 210, 60, 21);

        jRadioButtonMedia.setText("Media");
        getContentPane().add(jRadioButtonMedia);
        jRadioButtonMedia.setBounds(350, 230, 70, 21);

        jRadioButtonAlta.setText("Alta");
        getContentPane().add(jRadioButtonAlta);
        jRadioButtonAlta.setBounds(350, 250, 70, 21);

        setSize(new java.awt.Dimension(564, 431));
        setLocationRelativeTo(null);
    }

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            cadastrarTarefa(usuarioLogado);
            salvarTarefasEmJSON(usuarioLogado);
            this.dispose();
        } catch (ParseException | DataInvalidaException | IOException e) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Por favor, insira uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public void cadastrarTarefa(String usuario) throws ParseException, main.java.com.mycompany.gerenciadordetarefas.controller.DataInvalidaException, IOException {
//        Tarefa novaTarefa = new Tarefa(
//                usuario,
//                jTextFieldTitulo.getText(),
//                jTextArea1.getText(),
//                DataValidator.validarData(jFormattedTextFieldData.getText()),
//                jRadioButtonConcluida.isSelected(),
//                obterImportanciaSelecionada()
//        );
//
//        tarefaController.cadastrarTarefa(novaTarefa);
//
//        JOptionPane.showMessageDialog(this, "Tarefa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
//    }

    public void cadastrarTarefa(String usuario) throws ParseException, DataInvalidaException, IOException {
        String titulo = jTextFieldTitulo.getText();
        String descricao = jTextArea1.getText();
        String dataConclusao = jFormattedTextFieldData.getText();

        // Verificar se o título foi fornecido
        if (titulo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, forneça um título para a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar se a descrição foi fornecida
        if (descricao.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, forneça uma descrição para a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar se a data de conclusão foi fornecida e é válida
        if (dataConclusao.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, forneça uma data de conclusão para a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DataValidator.validarData(dataConclusao);
        } catch (DataInvalidaException e) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Por favor, insira uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar se pelo menos uma opção de status foi marcada
        if (!jRadioButtonConcluida.isSelected() && !jRadioButtonNaoConcluida.isSelected()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione o status da tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar se pelo menos uma opção de importância foi marcada
        if (!jRadioButtonBaixa.isSelected() && !jRadioButtonMedia.isSelected() && !jRadioButtonAlta.isSelected()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione a importância da tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        else {
            // Restante do código para criar a nova tarefa
            Tarefa novaTarefa = new Tarefa(
                    usuario,
                    titulo,
                    descricao,
                    DataValidator.validarData(dataConclusao),
                    jRadioButtonConcluida.isSelected(),
                    obterImportanciaSelecionada()
            );

            tarefaController.cadastrarTarefa(novaTarefa);

            JOptionPane.showMessageDialog(this, "Tarefa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }}



    private void salvarTarefasEmJSON(String usuario) throws IOException {

        TarefaController tarefaController = new TarefaController();

        // Carregar as tarefas existentes do arquivo JSON
        List<Tarefa> tarefasExistente = TarefaRepository.carregarTarefas(usuario);

        // Criar a nova tarefa com os dados informados na interface
        Tarefa novaTarefa = new Tarefa(
                usuario,
                jTextFieldTitulo.getText(),
                jTextArea1.getText(),
                jFormattedTextFieldData.getText(),
                jRadioButtonConcluida.isSelected(),
                obterImportanciaSelecionada()
        );

        // Adicionar a nova tarefa à lista existente
        tarefasExistente.add(novaTarefa);

        // Salvar a lista atualizada no arquivo JSON
        tarefaPersistence.salvarTarefas(tarefasExistente);

        // Atualizar a lista de tarefas na interface (se necessário)
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.atualizarListaTarefas(tarefasExistente);

    }

    public String obterImportanciaSelecionada() {
        if (jRadioButtonBaixa.isSelected()) {
            return "Baixa";
        } else if (jRadioButtonMedia.isSelected()) {
            return "Média";
        } else if (jRadioButtonAlta.isSelected()) {
            return "Alta";
        } else {
            return "";
        }
    }

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButtonAlta;
    private javax.swing.JRadioButton jRadioButtonBaixa;
    private javax.swing.JRadioButton jRadioButtonConcluida;
    private javax.swing.JRadioButton jRadioButtonMedia;
    private javax.swing.JRadioButton jRadioButtonNaoConcluida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldTitulo;

}