module com.mycompany.ewalletproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires junit;
    requires java.desktop;
    //requires avdev;
    
    opens com.mycompany.ewalletproject to javafx.fxml;
    exports com.mycompany.ewalletproject;
    opens com.mycompany.ewalletproject.controllers to javafx.fxml;
    exports com.mycompany.ewalletproject.controllers;
    opens com.mycompany.ewalletproject.threads to javafx.fxml;
    exports com.mycompany.ewalletproject.threads;
    opens com.mycompany.ewalletproject.walletitems to javafx.fxml;
    exports com.mycompany.ewalletproject.walletitems;
    opens com.mycompany.ewalletproject.storage to javafx.fxml;
    exports com.mycompany.ewalletproject.storage;
    opens com.mycompany.ewalletproject.observables to javafx.fxml;
    exports com.mycompany.ewalletproject.observables;
}
