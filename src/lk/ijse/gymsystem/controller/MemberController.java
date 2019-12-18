package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.*;
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
import lk.ijse.gymsystem.business.custom.MemberBO;
import lk.ijse.gymsystem.business.custom.PackageBO;
import lk.ijse.gymsystem.business.custom.impl.MemberBOImpl;
import lk.ijse.gymsystem.business.custom.impl.PackageBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.entity.Member;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


public class MemberController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private JFXTextField txtMemberID;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXRadioButton btnMaleRadioButton;

    @FXML
    private ToggleGroup memberGenderRadioGroup;

    @FXML
    private JFXRadioButton btnFemaleRadioButton;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtHeight;

    @FXML
    private JFXTextField txtWeight;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnNext;

    @FXML
    private TableView<MemberDTO> tableMember;

    @FXML
    private JFXDatePicker dateDateOfBirth;

    @FXML
    private JFXDatePicker dateDateOfJoin;

    @FXML
    private JFXDatePicker dateDateOfEnd;

    @FXML
    private JFXComboBox<String> comboPackage;

    @FXML
    private JFXTextField txtPackageName;

    @FXML
    private Label btnHome;

    private MemberBO memberBO = new MemberBOImpl();

    private PackageBO packageBO = new PackageBOImpl();


    private void searchPackageID(ActionEvent event) {
        try {
            PackageDTO searchPackageType = packageBO.searchPackage(comboPackage.getSelectionModel().getSelectedItem());
            txtPackageName.setText(searchPackageType.getPackage_name());
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnMaleRadioButton.setUserData("Male");
        btnFemaleRadioButton.setUserData("Female");
        try {
            loadAllMember();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            ArrayList<PackageDTO> allPackage = packageBO.getAll();
            ArrayList<String> id = new ArrayList<>();

            for (PackageDTO packageDTO : allPackage) {
                id.add(packageDTO.getPackage_id());
            }
            comboPackage.setItems(FXCollections.observableArrayList(id));
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    void txtMemberIDOnAction(ActionEvent event) {
        txtMemberName.requestFocus();
    }

    @FXML
    void txtMemberNameOnAction(ActionEvent event) {
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
        comboPackage.requestFocus();
    }
    @FXML
    void dateDateOfJoinOnAction(ActionEvent event) {
        dateDateOfEnd.requestFocus();
    }
    @FXML
    void dateDateOfEndOnAction(ActionEvent event) {
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
            MemberDTO memberDTO = new MemberDTO(
                    txtMemberID.getText(),
                    txtMemberName.getText(),
                    txtAddress.getText(),
                    Integer.parseInt(txtContactNo.getText()),
                    txtEmail.getText(),
                    memberGenderRadioGroup.getSelectedToggle().getUserData().toString(),
                    dateDateOfBirth.getValue().toString(),
                    Integer.parseInt(txtAge.getText()),
                    comboPackage.getSelectionModel().getSelectedItem(),
                    dateDateOfJoin.getValue().toString(),
                    dateDateOfEnd.getValue().toString(),
                    txtHeight.getText(),
                    txtWeight.getText()
            );
            try {
                boolean b = memberBO.addMember(memberDTO);

                if (b)
                    Common.showMessage("ADDED SUCCESSFULLY !");
                loadAllMember();
                setClear();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        boolean deleted = memberBO.deleteMember(txtMemberID.getText());
        if (deleted) {
            Common.showMessage("DELETE SUCCESSFULLY!");
            loadAllMember();
            setClear();
        }
    }

    @FXML
    void btnHomeOnMouseClicked(MouseEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Home.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);

    }


    @FXML
    void btnNextOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/PaymentDetails.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws Exception {
        try {
            MemberDTO memberDTO = memberBO.searchMember(txtMemberID.getText());
            txtMemberID.setText(memberDTO.getMember_id());
            txtMemberName.setText(memberDTO.getMember_name());
            txtAddress.setText(memberDTO.getAddress());
            txtContactNo.setText(memberDTO.getContact_no() + "");
            txtEmail.setText(memberDTO.getE_mail());
//            memberGenderRadioGroup.selectToggle(memberDTO.getGender());
            dateDateOfBirth.setAccessibleText(memberDTO.getDate_of_birth());
            txtAge.setText(memberDTO.getAge() + "");
//            comboPackage.setItems(memberDTO.getPackage_id() + "");
            dateDateOfJoin.setAccessibleText(memberDTO.getDate_of_join());
            dateDateOfEnd.setAccessibleText(memberDTO.getDate_of_end());
            txtHeight.setText(memberDTO.getHeight());
            txtWeight.setText(memberDTO.getWeight());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
            MemberDTO memberDTO = new MemberDTO(
                    txtMemberID.getText(),
                    txtMemberName.getText(),
                    txtAddress.getText(),
                    Integer.parseInt(txtContactNo.getText()),
                    txtEmail.getText(),
                    memberGenderRadioGroup.getSelectedToggle().getUserData().toString(),
                    dateDateOfBirth.getValue().toString(),
                    Integer.parseInt(txtAge.getText()),
                    comboPackage.getSelectionModel().getSelectedItem(),
                    dateDateOfJoin.getValue().toString(),
                    dateDateOfEnd.getValue().toString(),
                    txtHeight.getText(),
                    txtWeight.getText()
            );
            try {
                boolean b = memberBO.updateMember(memberDTO);

                if (b)
                    Common.showMessage("UPDATE SUCCESSFULLY !");
                loadAllMember();
                setClear();
            } catch (Exception e) {
                Common.showError("NOT UPDATE !");
                e.printStackTrace();
            }

    }


    @FXML
    void comboPackageOnAction(ActionEvent event) {
        searchPackageID(event);
        dateDateOfJoin.requestFocus();

    }

    @FXML
    void txtPackageNameOnAction(ActionEvent event) {

    }

    private void loadAllMember() {
        ArrayList<MemberDTO> memberList;
        try {
            memberList = memberBO.getMember();
            ObservableList<MemberDTO> members = FXCollections.observableArrayList(memberList);
            tableMember.setItems(members);
            tableMember.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("member_id"));
            tableMember.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("member_name"));
            tableMember.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
            tableMember.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact_no"));
            tableMember.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("e_mail"));
            tableMember.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
            tableMember.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
            tableMember.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("age"));
            tableMember.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("package_id"));
            tableMember.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("date_of_join"));
            tableMember.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("date_of_end"));
            tableMember.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("height"));
            tableMember.getColumns().get(12).setCellValueFactory(new PropertyValueFactory<>("weight"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void tableMemberOnAction(MouseEvent event) {
        MemberDTO memberDTO = tableMember.getSelectionModel().getSelectedItem();
        txtMemberID.setText(memberDTO.getMember_id());
        txtMemberName.setText(memberDTO.getMember_name());
        txtAddress.setText(memberDTO.getAddress());
        txtContactNo.setText(memberDTO.getContact_no() + "");
        txtEmail.setText(memberDTO.getE_mail());
        memberGenderRadioGroup.setUserData(memberDTO.getGender());
        dateDateOfBirth.setValue(LocalDate.parse(memberDTO.getDate_of_birth()));
        txtAge.setText(memberDTO.getAge()+"");
        comboPackage.setAccessibleText(memberDTO.getPackage_id());
        txtPackageName.setText(memberDTO.getPackage_id());
        dateDateOfJoin.setValue(LocalDate.parse(memberDTO.getDate_of_join()));
        dateDateOfEnd.setValue(LocalDate.parse(memberDTO.getDate_of_end()));
        txtHeight.setText(memberDTO.getHeight());
        txtWeight.setText(memberDTO.getWeight());

    }

    private void setClear() {
        txtMemberID.clear();
        txtMemberName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtEmail.clear();
        memberGenderRadioGroup.selectToggle(null);
        dateDateOfBirth.getEditor().clear();
        txtAge.clear();
        comboPackage.getItems().clear();
        txtPackageName.clear();
        dateDateOfJoin.getEditor().clear();
        dateDateOfEnd.getEditor().clear();
        txtHeight.clear();
        txtWeight.clear();
    }
    private boolean memValidate() {
//        String sMid = txtMemberID.getText();
//        if (sMid.matches("[0-9]{9}[x|X|v|V]$")) {
//            txtMemberName.requestFocus();
//            String sName = txtMemberName.getText();
//            if (sName.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
//                txtAddress.requestFocus();
//                String addr = txtAddress.getText();
//                if (addr.matches("[A-Z0-9]{10,20}")) {
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
//                                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Height Again!", ButtonType.OK);
//                                    a.showAndWait();
//                                }
//                            } else {
//                                Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Age Again!", ButtonType.OK);
//                                a.showAndWait();
//                            }
//                        } else {
//                            Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the E-mail Again!", ButtonType.OK);
//                            a.showAndWait();
//                        }
//                    } else {
//                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Contact_No Again!", ButtonType.OK);
//                        a.showAndWait();
//                    }
//                } else {
//                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Address Again!", ButtonType.OK);
//                    a.showAndWait();
//                }
//            } else {
//                Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Member_Name Again!", ButtonType.OK);
//                a.showAndWait();
//            }
//        }else {
//            Alert a = new Alert(Alert.AlertType.INFORMATION, "Check the Member_ID Again!", ButtonType.OK);
//            a.showAndWait();
//        }
        return false;
    }

}
