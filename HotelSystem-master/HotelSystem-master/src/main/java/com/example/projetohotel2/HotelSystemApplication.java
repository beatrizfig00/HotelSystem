package com.example.projetohotel2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

import com.example.projetohotel2.Gui.TelaCadastroController;
import com.example.projetohotel2.Gui.TelaLoginController;
import com.example.projetohotel2.Gui.TelaPrincipalController;

public class HotelSystemApplication extends Application {
    private Stage primaryStage;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Image icon = new Image(getClass().getResourceAsStream("/com/example/icone.png"));
        primaryStage.getIcons().add(icon);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tela-login.fxml"));
            Parent root = fxmlLoader.load();
            TelaLoginController telaLoginController = fxmlLoader.getController();
            telaLoginController.inicializar(this);

            Scene scene = new Scene(root, 620, 480);

            primaryStage.setTitle("Tela de Login");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void telaPrincipal() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tela-principal.fxml"));
            Parent root = fxmlLoader.load();
            TelaPrincipalController telaPrincipalController = fxmlLoader.getController();
            telaPrincipalController.setHotelSystemApplication(this);

            Scene scene = new Scene(root, 1100, 684);

            primaryStage.setTitle("Tela Principal");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void telaCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tela-cadastro.fxml"));
            Parent root = loader.load();
            TelaCadastroController telaCadastroController = loader.getController();
            telaCadastroController.setHotelSystemApplication(this);

            Scene scene = new Scene(root, 550, 690);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Tela de Cadastro");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarTela(String fxmlFile, String title, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
