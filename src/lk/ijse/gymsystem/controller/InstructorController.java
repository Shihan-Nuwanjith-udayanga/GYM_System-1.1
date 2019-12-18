package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gymsystem.business.custom.InstructorBO;
import lk.ijse.gymsystem.business.custom.impl.InstructorBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.dto.InstructorDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class InstructorController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private JFXTextField txtInstructorID;

    @FXML
    private JFXTextField txtInstructorName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtSalery;

    @FXML
    private JFXTextField txtHeight;

    @FXML
    private JFXTextField txtWeight;

    @FXML
    private TableView<InstructorDTO> tableInstructor;

    @FXML
    private JFXRadioButton btnMaleRadioButton;

    @FXML
    private ToggleGroup instructorGenderRadioGroup;

    @FXML
    private JFXRadioButton btnFemaleRadioButton;

    @FXML
    private Label btnHome;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXDatePicker dateDateOfBirth;

    @FXML
    private JFXDatePicker dateDateOfJoin;

    private InstructorBO instructorBO = new InstructorBOImpl();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnMaleRadioButton.setUserData("Male");
        btnFemaleRadioButton.setUserData("Female");

        try {
            loadAllInstructor();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    void txtInstructorIDOnAction(ActionEvent event) {
        txtInstructorName.requestFocus();
    }

    @FXML
    void txtInstructorNameOnAction(ActionEvent event) {
        txtAddress.requestFocus();
    }
    @FXML
    void txtAddressOnAction(ActionEvent event) {
        txtContactNo.requestFocus();
    }

    @FXML
    void txtContactNoOnAction(ActionEvent event) {
        txtEmail.requestFocus();
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {
        dateDateOfBirth.requestFocus();
    }

    @FXML
    void dateDateOfBirthOnAction(ActionEvent event) {
        txtAge.requestFocus();
    }

    @FXML
    void txtAgeOnAction(ActionEvent event) {
        dateDateOfJoin.requestFocus();
    }
    @FXML
    void dateDateOfJoinOnAction(ActionEvent event) {
        txtSalery.requestFocus();
    }

    @FXML
    void txtSaleryOnAction(ActionEvent event) {
        txtHeight.requestFocus();
    }

    @FXML
    void txtHeightOnAction(ActionEvent event) {
        txtWeight.requestFocus();

    }

    @FXML
    void txtWeightOnAction(ActionEvent event) {

    }



    @FXML
    void btnAddOnAction(ActionEvent event) {
            InstructorDTO instructorDTO = new InstructorDTO(
                    txtInstructorID.getText(),
                    txtInstructorName.getText(),
                    txtAddress.getText(),
                    Integer.parseInt(txtContactNo.getText()),
                    txtEmail.getText(),
                    instructorGenderRadioGroup.getSelectedToggle().getUserData().toString(),
                    dateDateOfBirth.getValue().toString(),
                    Integer.parseInt(txtAge.getText()),
                    dateDateOfJoin.getValue().toString(),
                    Double.parseDouble(txtSalery.getText()),
                    txtHeight.getText(),
                    txtWeight.getText()
            );
            try {
                boolean b = instructorBO.addInstructor(instructorDTO);

                if (b)
                    Common.showMessage("ADDED SUCCESSFULLY!");
                loadAllInstructor();
                setClear();

            } catch (Exception e) {
                Common.showError("NOT ADDED !");
                e.printStackTrace();
            }
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        boolean deleted = instructorBO.deleteInstructor(txtInstructorID.getText());
        if (deleted){
            Common.showMessage("DELETE SUCCESSFULLY !");
            setClear();
            loadAllInstructor();
        }

    }

    @FXML
    void btnHomeOnMouseClicked(MouseEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Home.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
            InstructorDTO instructorDTO = new InstructorDTO(
                    txtInstructorID.getText(),
                    txtInstructorName.getText(),
                    txtAddress.getText(),
                    Integer.parseInt(txtContactNo.getText()),
                    txtEmail.getText(),
                    instructorGenderRadioGroup.getSelectedToggle().getUserData().toString(),
                    dateDateOfBirth.getValue().toString(),
                    Integer.parseInt(txtAge.getText()),
                    dateDateOfJoin.getValue().toString(),
                    Double.parseDouble(txtSalery.getText()),
                    txtHeight.getText(),
                    txtWeight.getText()
            );
            try {
                boolean b = instructorBO.updateInstructor(instructorDTO);

                if (b)
                    Common.showMessage("UPDATE SUCCESSFULLY!");
                loadAllInstructor();
                setClear();

            } catch (Exception e) {
                Common.showError("NOT UPDATE !");
                e.printStackTrace();
            }

    }


    @FXML
    void tableInstructorOnMouseClicked3(MouseEvent event) {
        InstructorDTO instructorDTO = tableInstructor.getSelectionModel().getSelectedItem();
        txtInstructorID.setText(instructorDTO.getInstructor_id());
        txtInstructorName.setText(instructorDTO.getInstructor_name());
        txtAddress.setText(instructorDTO.getAddress());
        txtContactNo.setText(instructorDTO.getContact_no()+"");
        txtEmail.setText(instructorDTO.getE_mail());
        instructorGenderRadioGroup.setUserData(instructorDTO.getGender());
        dateDateOfBirth.setValue(LocalDate.parse(instructorDTO.getDate_of_birth()));
        txtAge.setText(instructorDTO.getAge()+"");
        dateDateOfJoin.setValue(LocalDate.parse(instructorDTO.getDate_of_join()));
        txtSalery.setText(instructorDTO.getSalary()+"");
        txtHeight.setText(instructorDTO.getHeight());
        txtWeight.setText(instructorDTO.getWeight());

    }

    private void loadAllInstructor() {
        ArrayList<InstructorDTO> instructorList;
        try {
            instructorList = instructorBO.getAll();
            ObservableList<InstructorDTO> instructor = FXCollections.observableArrayList(instructorList);
            tableInstructor.setItems(instructor);
            tableInstructor.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Instructor_id"));
            tableInstructor.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Instructor_name"));
            tableInstructor.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
            tableInstructor.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Contact_no"));
            tableInstructor.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("E_mail"));
            tableInstructor.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Gender"));
            tableInstructor.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("Date_of_birth"));
            tableInstructor.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("Age"));
            tableInstructor.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("Date_of_join"));
            tableInstructor.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("Salary"));
            tableInstructor.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("Height"));
            tableInstructor.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("Weight"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void setClear() {
        txtInstructorID.clear();
        txtInstructorName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtEmail.clear();
        instructorGenderRadioGroup.setUserData(null);
        dateDateOfBirth.getEditor().clear();
        txtAge.clear();
        dateDateOfJoin.getEditor().clear();
        txtSalery.clear();
        txtHeight.clear();
        txtWeight.clear();
    }
    private boolean memValidate() {
//        String sMid = txtInstructorID.getText();
//        if (sMid.matches("[0-9]{9}[x|X|v|V]$")) {
//            txtInstructorName.requestFocus();
//            String sName = txtInstructorName.getText();
//            if (sName.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
//                txtAddress.requestFocus();
//                String addr = txtAddress.getText();
//                if (addr.matches("!\"\".equals")) {
//                    txtContactNo.requestFocus();
//                    String tel = txtContactNo.getText();
//                    if (tel.matches("^\\d{9,10}$")) {
//                        txtEmail.requestFocus();
//                        String email = txtEmail.getText();
//                        if (email.matches("^[1-9][0-9]?$")) {
//                            txtAge.requestFocus();
//                            String age = txtAge.getText();
//                            if (age.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
//                                txtHeight.requestFocus();
//                                String hei = txtHeight.getText();
//                                if (hei.matches("^[0-9]*S")) {
//                                    txtWeight.requestFocus();
//                                    String wei = txtWeight.getText();
//                                    if (wei.matches("^[0-9]*S")) {
//
//                                    } else {
//                                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Weight Again!", ButtonType.OK);
//                                        a.showAndWait();
//                                    }
//                                } else {
//                                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Weight Again!", ButtonType.OK);
//                                    a.showAndWait();
//                                }
//                            } else {
//                                Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Age Again!", ButtonType.OK);
//                                a.showAndWait();
//                            }
//                        } else {
//                            Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Contact_No Again!", ButtonType.OK);
//                            a.showAndWait();
//                        }
//                    } else {
//                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the E-mail Again!", ButtonType.OK);
//                        a.showAndWait();
//                    }
//                } else {
//                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Address Again!", ButtonType.OK);
//                    a.showAndWait();
//                }
//            } else {
//                Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Instructor_Name Again!", ButtonType.OK);
//                a.showAndWait();
//            }
//        }else {
//            Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Instructor_ID Again!", ButtonType.OK);
//            a.showAndWait();
//        }
        return false;
    }


}
