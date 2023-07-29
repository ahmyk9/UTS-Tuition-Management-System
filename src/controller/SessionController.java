package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;
import model.*;


public class SessionController extends Controller<Session>{
   
    
    @FXML private Button OkBtn;
    @FXML private Button CancelBtn;
    
    public void initialize(){
        stage.getIcons().add(new Image("view/book.png"));
    }
 
    
    
    public Session getSession(){
        return model;
    }


    
    @FXML public void openLogin(ActionEvent e) throws Exception {
        System.out.println("Login button activated");
        ViewLoader.showStage(new Faculties(), "/view/login.fxml",  "Sign In", new Stage());
        
    }
    
    @FXML public void openCancel(ActionEvent e){
        System.out.println("Cancel button works");
        stage.close();
    }

}
