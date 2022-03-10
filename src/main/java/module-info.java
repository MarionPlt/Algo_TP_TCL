module com.playout.tpfinalalgo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.playout.tpfinalalgo to javafx.fxml;
    exports com.playout.tpfinalalgo;
}