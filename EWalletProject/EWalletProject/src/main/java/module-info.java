module com.mycompany.ewalletproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires junit;

    opens com.mycompany.ewalletproject to javafx.fxml;
    exports com.mycompany.ewalletproject;
    opens com.mycompany.ewalletproject.controllers to javafx.fxml;
    exports com.mycompany.ewalletproject.controllers;
    opens com.mycompany.ewalletproject.tests to javafx.fxml;
    exports com.mycompany.ewalletproject.tests;
    opens com.mycompany.ewalletproject.threads to javafx.fxml;
    exports com.mycompany.ewalletproject.threads;
    opens com.mycompany.ewalletproject.walletitems to javafx.fxml;
    exports com.mycompany.ewalletproject.walletitems;
    opens com.mycompany.ewalletproject.storage to javafx.fxml;
    exports com.mycompany.ewalletproject.storage;
}
