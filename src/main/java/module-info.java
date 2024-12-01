module main.ascalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens main.ascalculator to javafx.fxml;
    exports main.ascalculator;
}