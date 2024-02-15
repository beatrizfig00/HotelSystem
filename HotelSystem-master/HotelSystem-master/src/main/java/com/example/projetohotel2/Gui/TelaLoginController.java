package com.example.projetohotel2.Gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Platform;
import com.example.projetohotel2.HotelSystemApplication;

public class TelaLoginController {

    @FXML
    private Button cadastroButton;
    @FXML
    private ComboBox<String> tipoUsuarioComboBox;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField senhaPasswordField;
    @FXML
    private Button entrarButton;

    private HotelSystemApplication hotelSystemApp;

    public void inicializar(HotelSystemApplication hotelSystemApp) {
        this.hotelSystemApp = hotelSystemApp;
    }

    @FXML
    private void realizarCadastro() {
        hotelSystemApp.telaCadastro();
    }

    @FXML
    private void botaoEntrar() {
        String login = loginTextField.getText();
        String senha = senhaPasswordField.getText();
        String tipoUsuarioSelecionado = tipoUsuarioComboBox.getValue();

        if (tipoUsuarioSelecionado == null) {
            System.out.println("Por favor, selecione o tipo de usuário.");
            return;
        }

        if (login.isEmpty() || senha.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        if ("Hóspede".equals(tipoUsuarioSelecionado)) {
            System.out.println("Login bem-sucedido como Hóspede");
            hotelSystemApp.telaPrincipal();
        } else if ("Administrador".equals(tipoUsuarioSelecionado)) {
            System.out.println("Login bem-sucedido como Administrador");
        } else {
            System.out.println("Tipo de usuário inválido.");
        }
    }

    @FXML
    private void botaoSair() {
        Platform.exit();
        System.exit(0);
    }
}
