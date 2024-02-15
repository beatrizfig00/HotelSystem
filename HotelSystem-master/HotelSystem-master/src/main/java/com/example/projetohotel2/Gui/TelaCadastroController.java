package com.example.projetohotel2.Gui;

import com.example.projetohotel2.HotelFachada;
import com.example.projetohotel2.HotelSystemApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroController {
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldSobrenome;
    @FXML
    private TextField textFieldCPF;
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldLogin;
    @FXML
    private TextField textFieldSenha;
    @FXML
    private TextField textFieldIdade;
    @FXML
    private TextField textFieldContato;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldEndereco;
    @FXML
    private ComboBox<String> comboBoxTipoUsuario;
    @FXML
    private Button buttonSalvar;
    @FXML
    private Button buttonVoltar;

    private HotelFachada hotelFachada;
    private HotelSystemApplication hotelApp;
    private Stage stage;

    public TelaCadastroController() {
        this.hotelFachada = HotelFachada.getInstance();
    }

    public void setHotelSystemApplication(HotelSystemApplication hotelApp) {
        this.hotelApp = hotelApp;
    }

    @FXML
    void initialize() {
        comboBoxTipoUsuario.getItems().addAll("Hóspede", "Administrador");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void salvar() {
    }

    @FXML
    void voltarParaLogin() {
        Stage stage = (Stage) buttonVoltar.getScene().getWindow();
        stage.close();
        hotelApp.start(new Stage());    }
}
