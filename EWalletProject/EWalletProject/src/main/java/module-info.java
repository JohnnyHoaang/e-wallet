module com.mycompany.ewalletproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    opens com.mycompany.ewalletproject to javafx.fxml;
    exports com.mycompany.ewalletproject;
    opens com.mycompany.ewalletproject.controllers to javafx.fxml;
    exports com.mycompany.ewalletproject.controllers;
}
