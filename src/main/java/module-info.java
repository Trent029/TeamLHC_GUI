module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens project.example to javafx.fxml;
    exports project.example;
}
