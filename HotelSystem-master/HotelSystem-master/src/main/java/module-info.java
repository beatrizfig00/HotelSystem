module com.example.projetohotel2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.projetohotel2.Gui to javafx.fxml;

    exports com.example.projetohotel2;
}