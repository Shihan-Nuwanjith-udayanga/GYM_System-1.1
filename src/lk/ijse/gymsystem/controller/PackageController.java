package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gymsystem.business.custom.PackageBO;
import lk.ijse.gymsystem.business.custom.impl.PackageBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.entity.Package;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.DoublePredicate;

public class PackageController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private Label btnHome;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXTextField txtPackageID;

    @FXML
    private JFXTextField txtPackageName;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private TableView<PackageDTO> tablePackage;

    @FXML
    private JFXRadioButton btn3MonthsRadioButton;

    @FXML
    private ToggleGroup packagesDurationRadioGroup;

    @FXML
    private JFXRadioButton btn6MonthsRadioButton;

    @FXML
    private JFXRadioButton btn1YearRadioButton;

    @FXML
    private JFXTextField txtDiscountAmount;

    @FXML
    private JFXTextField txtNewAmount;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdates;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnDetails;

    private PackageBO packageBO = new PackageBOImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn3MonthsRadioButton.setUserData("3Months");
        btn6MonthsRadioButton.setUserData("6Months");
        btn1YearRadioButton.setUserData("1Year");

        try {
            setPackage();
            loadAllPackage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    void txtPackageIDOnAction(ActionEvent event) {
        txtPackageName.requestFocus();
    }

    @FXML
    void txtPackageNameOnAction(ActionEvent event) {
        txtAmount.requestFocus();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        PackageDTO packageDTO = new PackageDTO(
                txtPackageID.getText(),
                txtPackageName.getText(),
                packagesDurationRadioGroup.getSelectedToggle().getUserData().toString(),
                Double.parseDouble(txtAmount.getText()),
                Double.parseDouble(txtDiscount.getText()),
                Double.parseDouble(txtDiscountAmount.getText()),
                Double.parseDouble(txtNewAmount.getText())
        );
        try {
            boolean b = packageBO.addPackage(packageDTO);

            if (b)
                Common.showMessage("ADDED SUCCESSFULLY !");
            loadAllPackage();
            setPackage();
            setAllClear();
        } catch (Exception e) {
            Common.showError("NOT ADDED !");
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeatailsOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/PackageDetails.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {

        boolean deleted = packageBO.deletePackage(txtPackageID.getText());
        if (deleted) {
            Common.showMessage("DELETE SUCCESSFULLY!");
            setPackage();
            loadAllPackage();
            setAllClear();
        }

    }

    @FXML
    void btnHomeOnMouseClicked(MouseEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Home.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnUpdatesOnAction(ActionEvent event) {
        PackageDTO packageDTO = new PackageDTO(
                txtPackageID.getText(),
                txtPackageName.getText(),
                packagesDurationRadioGroup.getSelectedToggle().getUserData().toString(),
                Double.parseDouble(txtAmount.getText()),
                Double.parseDouble(txtDiscount.getText()),
                Double.parseDouble(txtDiscountAmount.getText()),
                Double.parseDouble(txtNewAmount.getText())
        );
        try {
            boolean b = packageBO.updatePackage(packageDTO);

            if (b)
                Common.showMessage("UPDATE SUCCESSFULLY !");
            loadAllPackage();
            setPackage();
            setAllClear();
        } catch (Exception e) {
            Common.showError("NOT UPDATE !");
            e.printStackTrace();
        }


    }

    @FXML
    void txtSearchOnAction(ActionEvent event) throws Exception {
//        PackageDTO searchPackage =packageBO.searchPackage(txtSearch.getText());
//        txtPackageID.setText(searchPackage.getPackage_id());
//        txtPackageName.setText(searchPackage.getPackage_name());
//        packagesDurationRadioGroup.selectToggle(searchPackage.getDuration());
//        txtAmount.setText(searchPackage.getAmount());

    }

    @FXML
    void txtAmountOnAction(ActionEvent event) {
        txtDiscount.requestFocus();

    }

    @FXML
    void txtDiscountOnAction(ActionEvent event) {
        double amount = Double.parseDouble(txtAmount.getText());
        double discount = Double.parseDouble(txtDiscount.getText());
        txtDiscountAmount.setText(amount * discount / 100 + "");
        txtDiscountAmount.requestFocus();
    }

    @FXML
    void txtDiscountAmountOnAction(ActionEvent event) {

        double amountValue = Double.parseDouble(txtAmount.getText());
        double discountValue = Double.parseDouble(txtDiscountAmount.getText());

        double payAmount = amountValue - discountValue;

        txtNewAmount.setText(payAmount + "");
        txtNewAmount.requestFocus();
    }


    @FXML
    void txtNewAmountOnAction(ActionEvent event) {

    }
    private void setPackage() throws Exception {
        try {
            String Package;
            Package = IDGenerator.getNewID(" package", "package_id", "P");
            txtPackageID.setText(Package);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadAllPackage() {
        ArrayList<PackageDTO> PackageList;
        try {
            PackageList =packageBO.getAll();
            ObservableList<PackageDTO> packages = FXCollections.observableArrayList(PackageList);
            tablePackage.setItems(packages);
            tablePackage.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("package_id"));
            tablePackage.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("package_name"));
            tablePackage.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
            tablePackage.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("amount"));
            tablePackage.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("discount"));
            tablePackage.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("discount_amount"));
            tablePackage.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("new_amount"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void tablePackageOnMouseClicked(MouseEvent event) {
        PackageDTO packageDTO = tablePackage.getSelectionModel().getSelectedItem();
        txtPackageID.setText(packageDTO.getPackage_id());
        txtPackageName.setText(packageDTO.getPackage_name());
        packagesDurationRadioGroup.setUserData(packageDTO.getDuration());
        txtAmount.setText(packageDTO.getAmount()+"");
        txtDiscount.setText(packageDTO.getDiscount()+"");
        txtDiscountAmount.setText(packageDTO.getDiscount_amount()+"");
        txtNewAmount.setText(packageDTO.getNew_amount()+"");
    }

    private void setAllClear(){
        txtPackageName.clear();
        packagesDurationRadioGroup.selectToggle(null);
        txtAmount.clear();
        txtDiscount.clear();
        txtDiscountAmount.clear();
        txtNewAmount.clear();
    }
}

