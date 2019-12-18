package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.gymsystem.business.custom.InstructorBO;
import lk.ijse.gymsystem.business.custom.ScheduleBO;
import lk.ijse.gymsystem.business.custom.impl.InstructorBOImpl;
import lk.ijse.gymsystem.business.custom.impl.ScheduleBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dto.InstructorDTO;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.ScheduleDTO;
import lk.ijse.gymsystem.dto.ScheduleDetailsDTO;
import lk.ijse.gymsystem.entity.ScheduleDetails;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleController implements Initializable {
    @FXML
    private AnchorPane Pane;

    @FXML
    private JFXTextField txtScheduleId;

    @FXML
    private JFXTextField txtInstructorName;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private TableView<ScheduleDetailsDTO> tableSchedule;

    @FXML
    private Label lblDate;

    @FXML
    private JFXTextField txtNO;

    @FXML
    private JFXTextField txtExercise;

    @FXML
    private JFXTextField txtFrequency;

    @FXML
    private Label btnHome;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnPrint;

    @FXML
    private JFXButton btnEnter;

    @FXML
    private JFXComboBox<String> comboInstructorId;

    private ScheduleBO scheduleBO = new ScheduleBOImpl();

    private InstructorBO instructorBO = new InstructorBOImpl();

    private void searchInstructorID(ActionEvent event){
        try{
            InstructorDTO searchInstructorType = instructorBO.searchInstructor(comboInstructorId.getSelectionModel().getSelectedItem());
            txtInstructorName.setText(searchInstructorType.getInstructor_name());
        } catch (Exception e) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE,null,e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableSchedule.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("no"));
        tableSchedule.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("exercise"));
        tableSchedule.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("frequency"));
        setDate();
        try {
            setSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ArrayList<InstructorDTO> allInstructor= instructorBO.getAll();
            ArrayList<String> id = new ArrayList<>();

            for (InstructorDTO instructorDTO: allInstructor){
                id.add(instructorDTO.getInstructor_id());
            }
            comboInstructorId.setItems(FXCollections.observableArrayList(id));
        } catch (Exception e) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE,null,e);
        }

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        ScheduleDTO scheduleDTO=new ScheduleDTO(
                txtScheduleId.getText(),
                comboInstructorId.getSelectionModel().getSelectedItem(),
                txtInstructorName.getText()
        );
        ArrayList<ScheduleDetails>list = new ArrayList<>();
        ObservableList<ScheduleDetailsDTO>items = tableSchedule.getItems();
        for (ScheduleDetailsDTO item : items) {
            list.add(new ScheduleDetails(
                    txtScheduleId.getText(),
                    txtMemberId.getText(),
                    txtMemberName.getText(),
                    lblDate.getText(),
                    item.getNo(),
                    item.getExercise(),
                    item.getFrequency()));

        }try {
            boolean b = scheduleBO.addSchedule(scheduleDTO,list);

            if(b)
                    Common.showMessage("ADDED SUCCESSFULLY !");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnMouseClicked(MouseEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Home.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtDateOnAction(ActionEvent event) {

    }
    @FXML
    void txtExerciseOnAction(ActionEvent event) {
        txtFrequency.requestFocus();

    }

    @FXML
    void txtFrequencyOnAction(ActionEvent event) {
        btnEnter.requestFocus();

    }
    @FXML
    void txtNOAction(ActionEvent event) {
        txtExercise.requestFocus();

    }


    @FXML
    void comboInstructorIdOnAction(ActionEvent event) {
        searchInstructorID(event);

    }

    @FXML
    void tableScheduleOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnEnterOnAction(ActionEvent event) {
        ScheduleDetailsDTO scheduleDetailsDTO = new ScheduleDetailsDTO(
                txtScheduleId.getText(),
                txtMemberId.getText(),
                txtMemberName.getText(),
                lblDate.getText(),
                txtNO.getText(),
                txtExercise.getText(),
                txtFrequency.getText());
        tableSchedule.getItems().add(scheduleDetailsDTO);
        setClear();


    }

    private void setSchedule()throws Exception{
        try {
            String Schedule;
            Schedule = IDGenerator.getNewID("Schedule","Schedule_id","S");
            txtScheduleId.setText(Schedule);
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public void txtMemberIdOnAction(ActionEvent event) {
        String memberId = txtMemberId.getText();
        try {
            MemberDTO memberDTO = scheduleBO.searchMember(memberId);
            txtMemberName.setText(memberDTO.getMember_name());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  void setClear() {
        txtNO.clear();
        txtExercise.clear();
        txtFrequency.clear();
    }
}
