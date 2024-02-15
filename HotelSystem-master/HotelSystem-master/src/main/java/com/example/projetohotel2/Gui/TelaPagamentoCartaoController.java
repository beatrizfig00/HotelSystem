package com.example.projetohotel2.Gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
import java.time.LocalDate;

public class TelaPagamentoCartaoController {

    @FXML
    private Label valorTotalLabel;
    @FXML
    private TextField numeroCartaoTextField;
    @FXML
    private ToggleButton debitoToggleButton;
    @FXML
    private ToggleButton creditoToggleButton;
    @FXML
    private TextField numeroParcelasTextField;
    @FXML
    private Label mensagemPagamentoLabel;
    @FXML
    private Label valorParcelaLabel;
    private ContaAtual contaAtual;

    public TelaPagamentoCartaoController(String loginUsuario) {
        this.contaAtual = new ContaAtual(loginUsuario);
    }

    @FXML
    private void confirmarPagamento() {
        double valorTotalConta = contaAtual.getTotal();

        String numeroCartao = numeroCartaoTextField.getText();

        String tipoCartao = debitoToggleButton.isSelected() ? "Débito" : (creditoToggleButton.isSelected() ? "Crédito" : "");

        if (tipoCartao.isEmpty()) {
            mensagemPagamentoLabel.setText("Selecione o tipo do cartão!");
            return;
        }

        int numeroParcelas = tipoCartao.equalsIgnoreCase("Crédito") ? Integer.parseInt(numeroParcelasTextField.getText()) : 1;

        PagamentoPorCartao pagamentoPorCartao = new PagamentoPorCartao(
                valorTotalConta,
                LocalDate.now(),
                1,
                numeroCartao,
                tipoCartao,
                numeroParcelas
        );

        pagamentoPorCartao.realizarPagamento();

        mensagemPagamentoLabel.setText("Pagamento realizado com sucesso!");

        if (tipoCartao.equalsIgnoreCase("Crédito")) {
            double valorParcela = valorTotalConta / numeroParcelas;
            valorParcelaLabel.setText("Valor da Parcela: R$ " + valorParcela);
        } else {
            valorParcelaLabel.setText("");
        }
    }

    @FXML
    private void voltarParaTelaPagamento() {
        try {
            hotelSystemApp.getInstance().carregarTela("tela-pagamento.fxml", "Tela Pagamento", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void SairButton() {
        Platform.exit();
        System.exit(0);
    }
}
