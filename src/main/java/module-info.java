module uk.ac.hope.csc.hostel.management.system.hmsfx {

    requires javafx.controls;
    requires javafx.fxml;
    requires hmslib;

    opens uk.ac.hope.csc.hmsfx to javafx.fxml;
    exports uk.ac.hope.csc.hmsfx;
}