module com.example.programming_cw_sem2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;


    opens com.example.programming_cw_sem2 to javafx.fxml;
    exports com.example.programming_cw_sem2;
}