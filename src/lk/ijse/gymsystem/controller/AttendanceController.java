package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.gymsystem.business.custom.AttendanceBO;
import lk.ijse.gymsystem.business.custom.impl.AttendanceBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.dto.MemberDTO;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AttendanceController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private JFXTextField txtMemberID;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private TableView<AttendanceDTO> tableAttendance;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnDetails;

    @FXML
    private Label lblDate;

    @FXML
    private JFXTextField txtArrivalTime;

    @FXML
    private JFXTextField txtDepartureTime;

    @FXML
    private Label btnHome;

    AttendanceBO attendanceBO= new AttendanceBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDate();
        setClear();
        loadAllAttendance();

    }
    @FXML
    void txtMemberNameOnAction(ActionEvent event) {
        txtArrivalTime.requestFocus();
    }

    @FXML
    void txtArrivalTimeOnAction(ActionEvent event) {
        txtDepartureTime.requestFocus();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        AttendanceDTO attendanceDTO = new AttendanceDTO(
                txtMemberID.getText(),
                txtMemberName.getText(),
                lblDate.getText(),
                txtArrivalTime.getText(),
                txtDepartureTime.getText()
        );
        try {
            boolean b = attendanceBO.addAttendance(attendanceDTO);

            if (b)
                Common.showMessage("ADDED SUCCESSFULLY !");
            loadAllAttendance();
            setClear();
        } catch (Exception e) {
            Common.showMessage("NOT ADDED");
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        boolean delete = attendanceBO.deleteAttendance(txtMemberID.getText());
        if (delete){
            Common.showMessage("DELETE !");
            loadAllAttendance();
            setClear();
        }

    }

    @FXML
    void btnDetailsOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/AttendanceDetails.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnHomeOnMouseClicked(MouseEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Home.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        AttendanceDTO attendanceDTO = new AttendanceDTO(
                txtMemberID.getText(),
                txtMemberName.getText(),
                lblDate.getText(),
                txtArrivalTime.getText(),
                txtDepartureTime.getText()
        );
        try {
            boolean b = attendanceBO.updateAttendance(attendanceDTO);
            if (b)
                Common.showMessage("UPDATE SUCCESSFULLY !");
            loadAllAttendance();
            setClear();
        } catch (Exception e) {
            Common.showError("NOT UPDATE !");
            e.printStackTrace();
        }
    }

    @FXML
    void txtDateOnAction(ActionEvent event) {

    }
    private void setDate(){
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY:MM:dd").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void txtMemberIDOnAction(ActionEvent event) {
        String memberId = txtMemberID.getText();
        try {
            MemberDTO memberDTO = attendanceBO.searchMember(memberId);
            txtMemberName.setText(memberDTO.getMember_name());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadAllAttendance(){
        ArrayList<AttendanceDTO> attendanceList;
        try {
            attendanceList = attendanceBO.getAttendance();
            ObservableList<AttendanceDTO>attendance = FXCollections.observableArrayList(attendanceList);
            tableAttendance.setItems(attendance);
            tableAttendance.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Member_id"));
            tableAttendance.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Member_name"));
            tableAttendance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Date"));
            tableAttendance.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Arrival_time"));
            tableAttendance.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Departure_time"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void setClear(){
        txtMemberID.clear();;
        txtMemberName.clear();
        txtArrivalTime.clear();
        txtDepartureTime.clear();
    }
    @FXML
    void tableAttendanceOnMouseClicked(MouseEvent event) {
        AttendanceDTO attendanceDTO= tableAttendance.getSelectionModel().getSelectedItem();
        txtMemberID.setText(attendanceDTO.getMember_id());
        txtMemberName.setText(attendanceDTO.getMember_name());
        lblDate.setText(attendanceDTO.getDate());
        txtArrivalTime.setText(attendanceDTO.getArrival_time());
        txtDepartureTime.setText(attendanceDTO.getArrival_time());

    }
}
