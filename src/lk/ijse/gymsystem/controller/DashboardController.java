package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private AnchorPane ShowPane;

    @FXML
    private Label lblActiveInstructors;

    @FXML
    private Label lblActiveMembers;

    @FXML
    private Label lblActivePackages;

    @FXML
    private JFXButton btnInstructors;

    @FXML
    private JFXButton btnRegistation;

    @FXML
    private JFXButton btnPackages;

    @FXML
    private JFXButton btnAttendance;

    @FXML
    private JFXButton btnPayments;

    @FXML
    private JFXButton btnSchedules;

    @FXML
    private JFXButton btnItems;

    @FXML
    private JFXButton btnProducts;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private ImageView btnMinimize;

    @FXML
    private ImageView btnClose;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTimeDate();
    }

    @FXML
    void btnAttendanceOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Attendance.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnCloseOnMouseClicked(MouseEvent event) throws Exception{
        Stage stage = (Stage) AnchorPane.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"ARE YOU SURE ?", ButtonType.YES);
        alert.showAndWait();
        stage.close();
        //System.exit(0);

    }

    @FXML
    void btnInstructorsOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Instructor.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnItemsOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Item.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event)  {
        System.exit(0);

    }

    @FXML
    void btnMinimizeOnMouseClicked(MouseEvent event) {
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainStage.setIconified(true);

    }

    @FXML
    void btnPackagesOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Package.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnPaymentsOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/PaymentDetails.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnProductsOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Product.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);

    }

    @FXML
    void btnRegistationOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Member.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);
    }

    @FXML
    void btnSchedulesOnAction(ActionEvent event) throws Exception {
        AnchorPane loadPane = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Schedule.fxml"));
        Scene scene = new Scene(loadPane);
        ShowPane.getChildren().setAll(loadPane);

    }

    private void setTimeDate(){
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
                lblDate.setText(new SimpleDateFormat("YYYY:MM:dd").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }
}
