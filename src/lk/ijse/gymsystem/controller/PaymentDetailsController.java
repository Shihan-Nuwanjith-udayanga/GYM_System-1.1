package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.*;
import com.sun.javafx.collections.MappingChange;
import com.sun.jmx.remote.security.NotificationAccessController;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.gymsystem.business.custom.MemberBO;
import lk.ijse.gymsystem.business.custom.PackageBO;
import lk.ijse.gymsystem.business.custom.PaymentBO;
import lk.ijse.gymsystem.business.custom.impl.MemberBOImpl;
import lk.ijse.gymsystem.business.custom.impl.PackageBOImpl;
import lk.ijse.gymsystem.business.custom.impl.PaymentBOImpl;
import lk.ijse.gymsystem.common.Common;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.db.DBConnection;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.dto.MemberDTO;
import lk.ijse.gymsystem.dto.PackageDTO;
import lk.ijse.gymsystem.dto.PaymentDTO;
import lk.ijse.gymsystem.entity.Payment;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.management.Notification;
import javax.smartcardio.CommandAPDU;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentDetailsController implements Initializable {
    @FXML
    private AnchorPane Pane;

    @FXML
    private Label btnHome;

    @FXML
    private JFXTextField txtPaymentId;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private JFXRadioButton btnCashRadioButton;

    @FXML
    private ToggleGroup paymentMethodRadioGroup;

    @FXML
    private JFXRadioButton btnCreditCardRadioButton;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private JFXTextField txtCash;

    @FXML
    private JFXTextArea txtDescription;

    @FXML
    private TableView<PaymentDTO> tablePaymentDetails;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnPrintBill;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtPackageId;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private JFXTextField txtBalance;

    @FXML
    private Label lblDate;

    @FXML
    private JFXComboBox<String> comboPackage;


    @FXML
    private JFXTextField txtPackageName;

    @FXML
    private JFXDatePicker dateDate;



    private PaymentBO paymentBO = new PaymentBOImpl();

    private MemberBO memberBO = new MemberBOImpl();

    private PackageBO packageBO = new PackageBOImpl();

    private void searchPackageID(ActionEvent event) {
        try {
            PackageDTO searchPackageType = packageBO.searchPackage(comboPackage.getSelectionModel().getSelectedItem());
            txtPackageName.setText(searchPackageType.getPackage_name());
            txtDuration.setText(searchPackageType.getDuration());
            txtAmount.setText(searchPackageType.getAmount()+"");
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCashRadioButton.setUserData("Cash");
        btnCreditCardRadioButton.setUserData("Credit_Card");
        try {
            setPayment();
            setDate();
            loadAllPayment();
            setClear();
        }catch (Exception e){
            e.printStackTrace();
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

    private void setPayment()throws Exception {
        try {
            String Payment;
            Payment = IDGenerator.getNewID("Payment","Payment_Id","PAY:");
            txtPaymentId.setText(Payment);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        PaymentDTO paymentDTO = new PaymentDTO(
                txtPaymentId.getText(),
                txtMemberId.getText(),
                txtMemberName.getText(),
                comboPackage.getSelectionModel().getSelectedItem(),
                txtPackageName.getText(),
                txtDuration.getText(),
                lblDate.getText(),
                paymentMethodRadioGroup.getSelectedToggle().getUserData().toString(),
                Double.parseDouble(txtAmount.getText()),
                Double.parseDouble(txtCash.getText()),
                Double.parseDouble(txtBalance.getText()),
                txtDescription.getText()
        );
        try {
            boolean b = paymentBO.addPayment(paymentDTO);

            if (b)
                Common.showMessage("ADDED SUCCESSFULLY !");
            setPayment();
            loadAllPayment();
            setClear();
        } catch (Exception e) {
            Common.showError("NOT ADDED !");
            e.printStackTrace();
        }

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Member.fxml"));
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
    void comboPackageOnAction(ActionEvent event) {
        searchPackageID(event);

    }

    @FXML
    void btnPrintBillOnAction(ActionEvent event) {
       try {
//           File path = new File("/lk/ijse/gymsystem/reports/Payment.jasper");
           InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/gymsystem/reports/Payment.jasper");
//           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(path);
           Map<String,Object>map=new HashMap<>();
           map.put("payment_id", txtPaymentId.getText());
           map.put("member_id", txtMemberId.getText());
           map.put("member_name", txtMemberName.getText());
           map.put("package_id", comboPackage.getAccessibleText());
           map.put("package_name", txtPackageName.getText());
           map.put("duration", txtDuration.getText());
           map.put("date", lblDate.getText());
           map.put("amount", Double.parseDouble(txtAmount.getText()));
           map.put("cash", Double.parseDouble(txtCash.getText()));
           map.put("balance", Double.parseDouble(txtBalance.getText()));
           map.put("description", txtDescription.getText());
           JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,map,new JREmptyDataSource());
           JasperViewer.viewReport(jasperPrint,false);
       }catch (JRException ex){
           Logger.getLogger(Payment.class.getName()).log(Level.SEVERE,null,ex);
       }
    }

    @FXML
    void txtDateOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

        try {
            PaymentDTO paymentDTO = paymentBO.searchPayment(txtSearch.getText());
            txtPaymentId.setText(paymentDTO.getPayment_id());
            txtMemberId.setText(paymentDTO.getMember_id());
            txtMemberName.setText(paymentDTO.getMember_name());
            comboPackage.setAccessibleText(paymentDTO.getPackage_id());
            txtPackageName.setText(paymentDTO.getPackage_name());
            txtDuration.setText(paymentDTO.getDuration());
            lblDate.setText(paymentDTO.getDate());
//            paymentMethodRadioGroup.setText(attendanceDTO.getPackage_name());
            txtAmount.setText(paymentDTO.getAmount()+"");
            txtCash.setText(paymentDTO.getCash()+"");
            txtBalance.setText(paymentDTO.getBalance()+"");
            txtDescription.setText(paymentDTO.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dateDateOnAction(ActionEvent event) {

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
            MemberDTO memberDTO = paymentBO.searchMember(memberId);
            txtMemberName.setText(memberDTO.getMember_name());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void txtAmountOnAction(ActionEvent event) {
        txtCash.requestFocus();

    }

    @FXML
    void txtCashOnAction(ActionEvent event) {
        double amount = Double.parseDouble(txtAmount.getText());
        double cash = Double.parseDouble(txtCash.getText());

        double sum=cash-amount;
        txtBalance.setText(sum+"");
        txtBalance.requestFocus();

    }

    @FXML
    void txtBalanceOnAction(ActionEvent event) {
        txtDescription.requestFocus();
    }

    @FXML
    void tablePaymentDetailsOnAction(MouseEvent event) {

        PaymentDTO paymentDTO= tablePaymentDetails.getSelectionModel().getSelectedItem();
        txtPaymentId.setText(paymentDTO.getPayment_id());
        txtMemberId.setText(paymentDTO.getMember_id());
        txtMemberName.setText(paymentDTO.getMember_name());
        comboPackage.setAccessibleText(paymentDTO.getPackage_id());
        txtPackageName.setText(paymentDTO.getPackage_name());
        txtDuration.setText(paymentDTO.getDuration());
        lblDate.setText(paymentDTO.getDate());
//        paymentMethodRadioGroup.setText(attendanceDTO.getPackage_name());
        txtAmount.setText(paymentDTO.getAmount()+"");
        txtCash.setText(paymentDTO.getCash()+"");
        txtBalance.setText(paymentDTO.getBalance()+"");
        txtDescription.setText(paymentDTO.getDescription());
    }

    private void loadAllPayment() {
        ArrayList<PaymentDTO> PaymentList;
        try {
            PaymentList =paymentBO.getAllPayment();
            ObservableList<PaymentDTO> payment = FXCollections.observableArrayList(PaymentList);
            tablePaymentDetails.setItems(payment);
            tablePaymentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("payment_id"));
            tablePaymentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("member_id"));
            tablePaymentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void setClear(){
        txtMemberId.clear();
        txtMemberName.clear();
        comboPackage.getItems().clear();
        txtPackageName.clear();
        txtDuration.clear();
        paymentMethodRadioGroup.selectToggle(null);
        txtAmount.clear();
        txtCash.clear();
        txtBalance.clear();
        txtDescription.clear();
    }
}
