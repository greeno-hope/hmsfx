package uk.ac.hope.csc.hmsfx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import uk.ac.hope.csc.hostel.management.system.*;

import java.io.File;
import java.net.URL;
import java.util.List;

public class HmsController {

    private HManagementSystem hms;
    private boolean isInitialised = false;

    public HmsController() {

        hms = new HManagementSystem();
    }

    private void initController() {

        URL url = this.getClass().getClassLoader().getResource("rooms.csv");
        File roomsFile = new File(url.getFile());
        url = this.getClass().getClassLoader().getResource("students.csv");
        File studentsFile = new File(url.getFile());
        hms.init(roomsFile, studentsFile);

    }

    @FXML
    private Button buttonAddTenant;

    @FXML
    private Button buttonDisplayTenants;

    @FXML
    private Button buttonRemoveTenant;

    @FXML
    private Button buttonSQ;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldRoomNumber;

    @FXML
    private TextField textFieldSid;

    @FXML
    private TextArea textAreaTenantRoom;

    @FXML
    void onButtonAddTenant(ActionEvent event) {

    }

    @FXML
    void onButtonDisplayTenants(ActionEvent event) {
        if(! isInitialised) {
            initController();
        }

        List<Student> students = hms.getStudentsOrderedByName();
        textAreaTenantRoom.clear();
        StringBuilder sb = new StringBuilder();
        sb.append("STUDENTS: \n");
        for(Student s: students) {
            int sid = s.getSid();
            String fname = s.getFname();
            String lname = s.getLname();
            int roomNumber = s.getRoom().getRoomNumber();
            sb.append(String.format("%8d\t", sid));
            sb.append(String.format("%-20s\t", fname));
            sb.append(String.format("%-20s\t", lname));
            sb.append(String.format("Room number: %03d", roomNumber));
            sb.append("\n");

        }
        textAreaTenantRoom.setText(sb.toString());
    }

    @FXML
    void onButtonRemoveTenant(ActionEvent event) {

    }

    @FXML
    void onButtonOccupiedRooms(ActionEvent event) {

    }

    @FXML
    void onButtonEmptyRooms(ActionEvent event) {

    }

    @FXML
    void onButtonSQ(ActionEvent event) {

    }

}
