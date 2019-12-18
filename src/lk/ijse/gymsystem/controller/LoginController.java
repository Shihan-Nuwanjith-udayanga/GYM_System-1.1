package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLigin;

    @FXML
    private Label txtClose;

    @FXML
    void txtCloseOnMouseClicked(MouseEvent event) {
        System.exit(0);

    }

    String userName = "shihan";
    String passWord = "123";

    @FXML
    void btnLoginOnAction(ActionEvent actionEvent) throws Exception {

        String use = txtUserName.getText();
        String password = txtPassword.getText();

        if (use.equalsIgnoreCase(userName) && password.equalsIgnoreCase(passWord)) {

            Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/gymsystem/view/Dashboard.fxml "));
            Scene scene = new Scene(parent);
            Stage mainStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            mainStage.setScene(scene);
            mainStage.setWidth(1366);
            mainStage.setHeight(768);
            mainStage.centerOnScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Login", ButtonType.OK);
            alert.showAndWait();
        }


//        if (text.equalsIgnoreCase("shihan")&& password.equalsIgnoreCase("1998")) {
//            Parent parent1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/gymsystem/view/Dashboard.fxml"));
//            Scene scene1 = new Scene(parent1);
//            Stage stage = (Stage) this.btnLigin.getScene().getWindow();
//            stage.setScene(scene1);
//            stage.centerOnScreen();
//            stage.show();
//
//        }else {
//           Alert alert = new Alert(Alert.AlertType.WARNING,"Invalid Login", ButtonType.OK);
//           alert.showAndWait();
//        }

    }


    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        btnLigin.requestFocus();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
