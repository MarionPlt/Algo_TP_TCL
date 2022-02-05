module com.example.tpalgo_tcl {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.tpalgo_tcl to javafx.fxml;
    exports com.example.tpalgo_tcl;
}