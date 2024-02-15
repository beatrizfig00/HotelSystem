package com.example.projetohotel2.Gui;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import com.example.projetohotel2.Negocio.ContaAtual;

import java.io.IOException;

public class TelaTransporteController {

    @FXML
    private CheckBox taxiCheckBox;
    @FXML
    private CheckBox carroparticularCheckBox;
    @FXML
    private CheckBox limusineCheckBox;
    @FXML
    private Label valorTotalLabel;

    private ContaAtual contaAtual;

    private double taxi = 7.0;
    private double carroparticular = 5.0;
    private double limusine = 12.0;

    @FXML
    private void initialize(String loginHospede) {
        this.contaAtual = new ContaAtual(loginHospede);
    }

    @FXML
    private void calcularValorTotal() {

    }
}