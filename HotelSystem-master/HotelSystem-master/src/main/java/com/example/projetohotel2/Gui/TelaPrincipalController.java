package com.example.projetohotel2.Gui;

import com.example.projetohotel2.HotelSystemApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.stage.Stage;
import java.io.IOException;

public class TelaPrincipalController {

    @FXML
    private MenuButton cadastroMenuButton;
    @FXML
    private MenuButton reservaMenuButton;
    @FXML
    private MenuButton servicosMenuButton;
    @FXML
    private MenuButton financeiroMenuButton;
    @FXML
    private MenuButton feedbackMenuButton;
    @FXML
    private MenuButton fidelidadeMenuButton;
    @FXML
    private Button voltarButton;

    private HotelSystemApplication hotelSystemApp;

    public void setHotelSystemApplication(HotelSystemApplication hotelSystemApp) {
        this.hotelSystemApp = hotelSystemApp;
    }

    @FXML
    private void botaoSair() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void botaoVoltar() {
        Stage stage = (Stage) voltarButton.getScene().getWindow();
        stage.close();
        hotelSystemApp.start(new Stage());
    }

    @FXML
    private void abrirTelaLavanderia() {
        try {
            hotelSystemApp.carregarTela("tela-lavanderia.fxml", "Serviço de Lavanderia", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaSpa() {
        try {
            // Oculta a tela principal
            Stage stage = (Stage) voltarButton.getScene().getWindow();
            stage.hide();

            // Abre a tela de SPA
            hotelSystemApp.carregarTela("tela-spa.fxml", "Serviço de SPA", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaTransporte() {
        try {
            hotelSystemApp.carregarTela("tela-transporte.fxml", "Serviço de Transporte", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaServicoQuarto() {
        try {
            hotelSystemApp.carregarTela("tela-servico-quarto.fxml", "Serviço de Quarto", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaAlimentacaoProdutos() {
        try {
            hotelSystemApp.carregarTela("tela-alimentacao-produtos.fxml", "Serviço de Vendas de Alimentação e Produtos", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaFeedback() {
        try {
            hotelSystemApp.carregarTela("tela-feedback.fxml", "Feedback", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaReserva() {
        try {
            hotelSystemApp.carregarTela("tela-reserva.fxml", "Reserva", 1100, 684);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaContaAtual() {
        try {
            hotelSystemApp.carregarTela("tela-conta-atual.fxml", "Conta Atual", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaPagamento() {
        try {
            hotelSystemApp.carregarTela("tela-pagamento.fxml", "Pagamento", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
