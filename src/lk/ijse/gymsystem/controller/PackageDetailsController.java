package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gymsystem.business.custom.MemberBO;
import lk.ijse.gymsystem.business.custom.PackageBO;
import lk.ijse.gymsystem.business.custom.PackageDetailBO;
import lk.ijse.gymsystem.business.custom.impl.MemberBOImpl;
import lk.ijse.gymsystem.business.custom.impl.PackageBOImpl;
import lk.ijse.gymsystem.business.custom.impl.PackageDetailBOImpl;
import lk.ijse.gymsystem.dto.ItemDTO;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PackageDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PackageDetailsController implements Initializable {
    @FXML
    private AnchorPane Pane;

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableView<MemberDTO> tablePackageDetails;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXTextField txtame;

    @FXML
    private JFXComboBox<String> comboPackage;

    @FXML
    private Button btnSearch;


    private PackageDetailBO packageBOImpl = new PackageDetailBOImpl();

    private PackageBO packageBO = new PackageBOImpl();

    private MemberBO memberBO = new MemberBOImpl();

    private void searchPackageID(ActionEvent event) {
        try {
            PackageDTO searchPackageType = packageBO.searchPackage(comboPackage.getSelectionModel().getSelectedItem());
            txtame.setText(searchPackageType.getPackage_name());
            txtPrice.setText(searchPackageType.getNew_amount() + "");
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    void btnBackOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Package.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);

    }

    @FXML
    void comboPackageOnAction(ActionEvent event) {
        searchPackageID(event);
        search(event);
        ArrayList<MemberDTO> memberList;

        try {
            memberList = packageBOImpl.getSearchMember(comboPackage.getSelectionModel().getSelectedItem());

            ObservableList<MemberDTO> members = FXCollections.observableArrayList(memberList);
            tablePackageDetails.setItems(members);
            tablePackageDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("member_id"));
            tablePackageDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("member_name"));
            tablePackageDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact_no"));
            tablePackageDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
            tablePackageDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("age"));
            tablePackageDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("date_of_join"));
            tablePackageDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("date_of_end"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtameOnAction(ActionEvent event) {

    }


    private void search(ActionEvent event) {

    }


    public void actionSearch(ActionEvent event) throws Exception {


    }

    public void searchBTN(ActionEvent event) throws Exception {
        ArrayList<MemberDTO> memberList;

        try {
            memberList = packageBOImpl.getSearchMember(txtSearch.getText());

            ObservableList<MemberDTO> members = FXCollections.observableArrayList(memberList);
            tablePackageDetails.setItems(members);
            tablePackageDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("member_id"));
            tablePackageDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("member_name"));
            tablePackageDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact_no"));
            tablePackageDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
            tablePackageDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("age"));
            tablePackageDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("date_of_join"));
            tablePackageDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("date_of_end"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
