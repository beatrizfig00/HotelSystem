package com.example.projetohotel2.Gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class TelaPagamentoDinheiroController {
    @FXML
    private Label valorTotalLabel;

    @FXML
    private TextField valorPagoTextField;
    private ContaAtual contaAtual;
    @FXML
    private Label trocoLabel;

    public TelaPagamentoDinheiroController(String loginUsuario) {
        this.contaAtual = new ContaAtual(loginUsuario);
    }

    @FXML
    private void confirmarPagamento() {
        double valorPago = Double.parseDouble(valorPagoTextField.getText());

        double valorTotalConta = contaAtual.getTotal();

        PagamentoPorDinheiro pagamentoPorDinheiro = new PagamentoPorDinheiro(
                valorTotalConta,
                LocalDate.now(),
                1,
                valorPago,  // Valor pago
                0.0
        );

        pagamentoPorDinheiro.realizarPagamento();

        trocoLabel.setText("Troco: R$ " + pagamentoPorDinheiro.getTroco());
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
