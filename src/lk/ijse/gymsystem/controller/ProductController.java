package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.gymsystem.business.custom.ProductBO;
import lk.ijse.gymsystem.business.custom.impl.ProductBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dto.ProductDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    @FXML
    private AnchorPane Pane;

    @FXML
    private Label lblHome;

    @FXML
    private JFXTextField txtProductId;

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXTextArea txtFeatures;

    @FXML
    private JFXTextField txtDiscountPrice;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtNewPrice;

    @FXML
    private TableView<ProductDTO> tableProduct;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnDelete;

    private ProductBO productBO =new ProductBOImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setProduct();
            loadAllProduct();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    void txtProductIdOnAction(ActionEvent event) {
        txtProductName.requestFocus();
    }

    @FXML
    void txtProductNameOnAction(ActionEvent event) {
        txtCategory.requestFocus();
    }
    @FXML
    void txtCategoryOnAction(ActionEvent event) {
        txtFeatures.requestFocus();
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {
        ProductDTO productDTO = new ProductDTO(
                txtProductId.getText(),
                txtProductName.getText(),
                txtCategory.getText(),
                txtFeatures.getText(),
                Double.parseDouble(txtPrice.getText()),
                Double.parseDouble(txtDiscount.getText()),
                Double.parseDouble(txtDiscountPrice.getText()),
                Double.parseDouble(txtNewPrice.getText())
        );
        try{
            boolean b = productBO.addProduct(productDTO);

            if (b)
                Common.showMessage("ADDED SUCCESSFULLY !");
            loadAllProduct();
            setProduct();
            setClear();
        } catch (Exception e) {
            Common.showError("NOT ADDED !");
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        boolean delete = productBO.deleteProduct(txtProductId.getText());
        if (delete){
            Common.showMessage("DELETE SUCCESSFULLY !");
            setProduct();
            loadAllProduct();
            setClear();
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        try {
            ProductDTO productDTO = productBO.searchProduct(txtProductId.getText());
            txtProductId.setText(productDTO.getProduct_id());
            txtProductName.setText(productDTO.getProduct_name());
            txtCategory.setText(productDTO.getCategory());
            txtFeatures.setText(productDTO.getFeatures());
            txtPrice.setText(productDTO.getPrice()+"");
            txtDiscount.setText(productDTO.getDiscount()+"");
            txtDiscountPrice.setText(productDTO.getDiscount_Price()+"");
            txtNewPrice.setText(productDTO.getNew_price()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ProductDTO productDTO= new ProductDTO(
                txtProductId.getText(),
                txtProductName.getText(),
                txtCategory.getText(),
                txtFeatures.getText(),
                Double.parseDouble(txtPrice.getText()),
                Double.parseDouble(txtDiscount.getText()),
                Double.parseDouble(txtDiscountPrice.getText()),
                Double.parseDouble(txtNewPrice.getText())
        );
        try{
            boolean b = productBO.updateProduct(productDTO);

            if (b)
                Common.showMessage("UPDATE SUCCESSFULLY !");
            loadAllProduct();
            setProduct();
            setClear();
        } catch (Exception e) {
            Common.showError("NOT UPDATE !");
            e.printStackTrace();
        }

    }

    @FXML
    void lblHomeOnMouseClicked(MouseEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Home.fxml"));
        Scene scene = new Scene(loadPane);
        Pane.getChildren().setAll(loadPane);

    }
    @FXML
    void txtPriceOnAction(ActionEvent event) {
        txtDiscount.requestFocus();
    }

    @FXML
    void txtDiscountOnAction(ActionEvent event) {
        double price = Double.parseDouble(txtPrice.getText());
        double discount = Double.parseDouble(txtDiscount.getText());
        txtDiscountPrice.setText(price * discount/100+"");
        txtDiscountPrice.requestFocus();

    }

    @FXML
    void txtDiscountPriceOnAction(ActionEvent event) {
        double price = Double.parseDouble(txtPrice.getText());
        double discountPrice = Double.parseDouble(txtDiscountPrice.getText());
        double payPrice = price - discountPrice;
        txtNewPrice.setText(payPrice + "");
        txtNewPrice.requestFocus();

    }


    @FXML
    void txtNewPriceOnAction(ActionEvent event) {

    }


    private void setProduct()throws Exception{
        String pro;
        pro = IDGenerator.getNewID("product","product_id","PRO");
        txtProductId.setText(pro);
    }
    private void loadAllProduct(){
        ArrayList<ProductDTO>productList;
        try {
            productList = productBO.getAll();
            ObservableList<ProductDTO>product = FXCollections.observableArrayList(productList);
            tableProduct.setItems(product);
            tableProduct.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("product_id"));
            tableProduct.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("product_name"));
            tableProduct.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("category"));
            tableProduct.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("features"));
            tableProduct.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
            tableProduct.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("discount"));
            tableProduct.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("discount_price"));
            tableProduct.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("new_price"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void tableProductOnMouseClicked(MouseEvent event) {
        ProductDTO productDTO=tableProduct.getSelectionModel().getSelectedItem();
        txtProductId.setText(productDTO.getProduct_id());
        txtProductName.setText(productDTO.getProduct_name());
        txtCategory.setText(productDTO.getCategory());
        txtFeatures.setText(productDTO.getFeatures());
        txtPrice.setText(productDTO.getPrice()+"");
        txtDiscount.setText(productDTO.getDiscount()+"");
        txtDiscountPrice.setText(productDTO.getDiscount_Price()+"");
        txtNewPrice.setText(productDTO.getNew_price()+"");
    }
    private void setClear(){
        txtProductName.clear();
        txtCategory.clear();
        txtFeatures.clear();
        txtPrice.clear();
        txtDiscount.clear();
        txtDiscountPrice.clear();
        txtNewPrice.clear();
    }

}
