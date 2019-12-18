package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
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
import lk.ijse.gymsystem.business.custom.ItemBO;
import lk.ijse.gymsystem.business.custom.impl.ItemBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dto.ItemDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private JFXTextField txtItemID;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtBrand;

    @FXML
    private JFXTextArea txtDescription;

    @FXML
    private JFXTextField txtBroughtPrice;

    @FXML
    private JFXDatePicker dateBoughtDate;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private TableView<ItemDTO> tableItem;

    @FXML
    private Label btnHome;


    private ItemBO itemBO = new ItemBOImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
           setItem();
           loadAllItem();
           setClear();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void txtItemIDOnAction(ActionEvent event) {
        txtItemName.requestFocus();
    }

    @FXML
    void txtItemNameOnAction(ActionEvent event) {
        txtBrand.requestFocus();
    }

    @FXML
    void txtBrandOnAction(ActionEvent event) {
        txtBroughtPrice.requestFocus();
    }

    @FXML
    void txtBroughtPriceOnAction(ActionEvent event) {
        dateBoughtDate.requestFocus();
    }

    @FXML
    void dateBoughtDateOnAction(ActionEvent event) {
        txtDescription.requestFocus();
    }




    @FXML
    void btnAddOnAction(ActionEvent event) {
        ItemDTO itemDTO = new ItemDTO(
                txtItemID.getText(),
                txtItemName.getText(),
                txtBrand.getText(),
                Double.parseDouble(txtBroughtPrice.getText()),
                dateBoughtDate.getValue().toString(),
                txtDescription.getText()
        );
        try {
            boolean b = itemBO.addItem(itemDTO);

            if (b)
                Common.showMessage("ADDED SUCCESSFULLY !");
            setItem();
            loadAllItem();
            setClear();
        } catch (Exception e) {
            Common.showError("NOT ADDED !");
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        boolean delete = itemBO.deleteItem(txtItemID.getText());
        if (delete){
            Common.showMessage("DELETE SUCCESSFULLY !");
            setItem();
            loadAllItem();
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
    void btnSearchOnAction(ActionEvent event) {
        try{
            ItemDTO itemDTO = itemBO.searchItem(txtItemID.getText());
            txtItemID.setText(itemDTO.getItem_id());
            txtItemName.setText(itemDTO.getItem_name());
            txtBrand.setText(itemDTO.getBrand());
            txtBroughtPrice.setText(itemDTO.getBought_price()+"");
            dateBoughtDate.setAccessibleText(itemDTO.getBought_date());
            txtDescription.setText(itemDTO.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemDTO itemDTO = new ItemDTO(
                txtItemID.getText(),
                txtItemName.getText(),
                txtBrand.getText(),
                Double.parseDouble(txtBroughtPrice.getText()),
                dateBoughtDate.getValue().toString(),
                txtDescription.getText()
        );
        try {
            boolean b = itemBO.updateItem(itemDTO);

            if (b)
                Common.showMessage("UPDATE SUCCESSFULLY !");
            setItem();
            loadAllItem();
            setClear();
        } catch (Exception e) {
            Common.showError("NOT UPDATE !");
            e.printStackTrace();
        }

    }

    private void setItem()throws Exception{
        try {
            String Item;
            Item = IDGenerator.getNewID("Item","Item_id","I");
            txtItemID.setText(Item);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadAllItem() {
        ArrayList<ItemDTO> itemList;
        try {
            itemList = itemBO.getAll();
            ObservableList<ItemDTO> item = FXCollections.observableArrayList(itemList);
            tableItem.setItems(item);
            tableItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("item_id"));
            tableItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("item_name"));
            tableItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("brand"));
            tableItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("bought_price"));
            tableItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bought_date"));
            tableItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("description"));
        } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
    private void setClear(){
        txtItemName.clear();
        txtBrand.clear();
        txtBroughtPrice.clear();
        dateBoughtDate.getEditor().clear();
        txtDescription.clear();
    }


    @FXML
    void tableItemOnMouseClicked(MouseEvent event) {
        ItemDTO itemDTO = tableItem.getSelectionModel().getSelectedItem();
        txtItemID.setText(itemDTO.getItem_id());
        txtItemName.setText(itemDTO.getItem_name());
        txtBrand.setText(itemDTO.getBrand());
        txtBroughtPrice.setText(itemDTO.getBought_price()+"");
        dateBoughtDate.setAccessibleText(itemDTO.getBought_date()+"");
        txtDescription.setText(itemDTO.getDescription());

    }
}
