package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gymsystem.business.custom.AttendanceBO;
import lk.ijse.gymsystem.business.custom.MemberBO;
import lk.ijse.gymsystem.business.custom.PackageBO;
import lk.ijse.gymsystem.business.custom.impl.AttendanceBOImpl;
import lk.ijse.gymsystem.business.custom.impl.MemberBOImpl;
import lk.ijse.gymsystem.business.custom.impl.PackageBOImpl;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.dto.MemberDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceDetailsController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private JFXTextField txtMemberID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearchMemberId;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private TableView<AttendanceDTO> tableMemberAttendance;

    @FXML
    private JFXButton btnBack;

    private AttendanceBO attendanceBO = new AttendanceBOImpl();


    private MemberBO memberBO = new MemberBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Attendance.fxml"));
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
    void txtSearchMemberIdOnAction(ActionEvent event) {

        ArrayList<AttendanceDTO> memberList;

        try {
//            AttendanceDTO attendanceDTODTO = attendanceBO.se(txtMemberID.getText());
            MemberDTO memberDTO = memberBO.searchMember(txtSearchMemberId.getText());
            txtMemberID.setText(memberDTO.getMember_id());
            txtMemberName.setText(memberDTO.getMember_name());

            memberList = attendanceBO.getSearchAttendance(txtSearchMemberId.getText());

            ObservableList<AttendanceDTO> members = FXCollections.observableArrayList(memberList);
            tableMemberAttendance.setItems(members);
            tableMemberAttendance.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("date"));
            tableMemberAttendance.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("arrival_time"));
            tableMemberAttendance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("departure_time"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
