
package com.mycompany.gerenciadordetarefas.view;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TelaCadastroUsuario extends javax.swing.JFrame {

    public static final String ARQUIVO_USUARIOS = "usuarios.json";
    public TelaCadastroUsuario() {
        initComponents();
    }

    private void initComponents() {

        jButtonVoltar = new javax.swing.JButton();
        blusuario = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        jTextFieldCriarUsuario = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jPasswordFieldCriarSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar);
        jButtonVoltar.setBounds(180, 120, 80, 23);

        blusuario.setText("Crie um usuário");
        getContentPane().add(blusuario);
        blusuario.setBounds(20, 10, 110, 16);

        lblsenha.setText("Crie uma senha");
        getContentPane().add(lblsenha);
        lblsenha.setBounds(20, 60, 100, 16);

        jTextFieldCriarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCriarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCriarUsuario);
        jTextFieldCriarUsuario.setBounds(20, 30, 240, 22);

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar);
        jButtonCadastrar.setBounds(20, 120, 90, 23);

        jPasswordFieldCriarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldCriarSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordFieldCriarSenha);
        jPasswordFieldCriarSenha.setBounds(20, 80, 240, 22);

        setSize(new java.awt.Dimension(290, 194));
        setLocationRelativeTo(null);
    }


    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String usuario = jTextFieldCriarUsuario.getText();
        String senha = new String(jPasswordFieldCriarSenha.getPassword());

        try {
            JSONArray usuariosArray;

            if (Files.exists(Paths.get(ARQUIVO_USUARIOS))) {
                String usuariosJson = new String(Files.readAllBytes(Paths.get(ARQUIVO_USUARIOS)));
                usuariosArray = new JSONArray(usuariosJson);
            } else {
                usuariosArray = new JSONArray();
            }

            JSONObject novoUsuario = new JSONObject();
            novoUsuario.put("Usuario", usuario);
            novoUsuario.put("Senha", senha);

            usuariosArray.put(novoUsuario);

            Files.write(Paths.get(ARQUIVO_USUARIOS), usuariosArray.toString().getBytes());

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

            jTextFieldCriarUsuario.setText("");
            jPasswordFieldCriarSenha.setText("");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao criar/atualizar o arquivo JSON: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jTextFieldCriarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
    }


    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }


    private void jPasswordFieldCriarSenhaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonCadastrarActionPerformed(null);
        }
    }
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel blusuario;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JPasswordField jPasswordFieldCriarSenha;
    private javax.swing.JTextField jTextFieldCriarUsuario;
}
