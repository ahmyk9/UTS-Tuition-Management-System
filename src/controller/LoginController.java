package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculties;
import model.Faculty;

public class LoginController extends Controller<Faculties> {
    
    public Faculty faculty;
    @FXML private TextField emailTf;
    @FXML private TextField passwordTf;
    @FXML private Label wrongLogIn;
    
    
    @FXML private Button OkBtn;
    @FXML private Button CancelBtn;
    
    public void initialize(){
        stage.getIcons().add(new Image("view/book.png"));
    }
    
    private String getTFEmail(){
        return emailTf.getText();
    }
    
    private String getTFPassword(){
        return passwordTf.getText();
    }
    
    private void setTFEmail(){ //this resets the email 
        emailTf.setText("");
    }
    
     private void setTFPassword(){ //this resets the password
        passwordTf.setText("");
    }
    
    public final Faculties getFaculties(){
        return model;
    }
    
    @FXML private void openOk(ActionEvent e) throws IOException{
        System.out.println("Ok button works");
        
        boolean hasFaculty = getFaculties().hasFaculty(getTFEmail(),getTFPassword()); 
        if(hasFaculty){ //if true
            faculty = getFaculties().getFaculty(getTFEmail(), getTFPassword());
            ViewLoader.showStage(faculty ,"/view/faculty.fxml", "Session Admin: " + faculty.getName() , new Stage());
            setTFEmail();
            setTFPassword();
            
        }
        
        else{
            wrongLogIn.setText("incorrect login details");
            setTFEmail();
            setTFPassword();
            System.out.println("incorrect login details");
        }

    }
        
    
    @FXML public void openCancel(ActionEvent e){
        System.out.println("Cancel button works");
        stage.close();
    }
}
