package com.example.projetohotel2.Gui;

import com.example.projetohotel2.Negocio.ContaAtual;
import com.example.projetohotel2.Negocio.Spa;
import com.example.projetohotel2.Negocio.Transacao;
import com.example.projetohotel2.Dados.RepositorioContaAtual;
import com.example.projetohotel2.HotelSystemApplication;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class TelaSpaController {

    @FXML
    private Button voltarButton;
    @FXML
    private CheckBox acupunturaCheckBox;
    @FXML
    private CheckBox massagemCheckBox;
    @FXML
    private CheckBox limpezaDePeleCheckBox;
    @FXML
    private CheckBox spaDosPesCheckBox;
    @FXML
    private CheckBox saunaCheckBox;
    @FXML
    private CheckBox hidromassagemCheckBox;
    @FXML
    private Label valorTotalLabel;
    private HotelSystemApplication application;
    private ContaAtual contaAtual;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField senhaPasswordField;

    private double acupuntura = 150.0;
    private double massagem = 90.0;
    private double limpezaDePele = 110.0;
    private double spaDosPes = 50.0;
    private double sauna = 20.0;
    private double hidromassagem = 30.0;
    private HotelSystemApplication hotelSystemApplication;
    private HotelSystemApplication hotelSystemApp;

    public void setApplication(HotelSystemApplication application) {
        this.application = application;
    }
      public void setHotelSystemApplication(HotelSystemApplication hotelSystemApp) {
        this.hotelSystemApp = hotelSystemApp;
    }
    @FXML
    private void initialize() {
        this.contaAtual = new ContaAtual("loginHospede"); // Substitua "loginHospede" pelo login do hospede
    }

    @FXML
    private void adicionarConta() {
        String login = loginTextField.getText();
        String senha = senhaPasswordField.getText();

        if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
            contaAtual = new ContaAtual(login);
        } else {
            System.out.println("Por favor, insira o login e senha.");
            return;
        }
    }

    @FXML
    private void calcularValorTotal() {
        double valorTotal = 0.0;

        if (acupunturaCheckBox.isSelected()) {
            Spa acupunturaServico = new Spa("Acupuntura", acupuntura);
            contaAtual.adicionarServico(acupunturaServico);
            valorTotal += acupunturaServico.getPreco();
            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Acupuntura", acupunturaServico.getPreco());
            RepositorioContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (massagemCheckBox.isSelected()) {
            Spa massagemServico = new Spa("Massagem", massagem);
            contaAtual.adicionarServico(massagemServico);
            valorTotal += massagemServico.getPreco();
            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Massagem", massagemServico.getPreco());
            RepositorioContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (limpezaDePeleCheckBox.isSelected()) {
            Spa limpezaDePeleServico = new Spa("Limpeza de Pele", limpezaDePele);
            contaAtual.adicionarServico(limpezaDePeleServico);
            valorTotal += limpezaDePeleServico.getPreco();
            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Limpeza de Pele", limpezaDePeleServico.getPreco());
            RepositorioContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (spaDosPesCheckBox.isSelected()) {
            Spa spaDosPesServico = new Spa("Spa dos Pés", spaDosPes);
            contaAtual.adicionarServico(spaDosPesServico);
            valorTotal += spaDosPesServico.getPreco();
            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Spa dos Pés", spaDosPesServico.getPreco());
            RepositorioContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (saunaCheckBox.isSelected()) {
            Spa saunaServico = new Spa("Sauna", sauna);
            contaAtual.adicionarServico(saunaServico);
            valorTotal += saunaServico.getPreco();
            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Sauna", saunaServico.getPreco());
            RepositorioContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (hidromassagemCheckBox.isSelected()) {
            Spa hidromassagemServico = new Spa("Hidromassagem", hidromassagem);
            contaAtual.adicionarServico(hidromassagemServico);
            valorTotal += hidromassagemServico.getPreco();
            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Hidromassagem", hidromassagemServico.getPreco());
            RepositorioContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        valorTotalLabel.setText(String.valueOf(valorTotal));
    }
    @FXML
    private void voltarButton() {
        try {
            hotelSystemApp.carregarTela("tela-principal.fxml", "Tela Principal", 1100, 684);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}