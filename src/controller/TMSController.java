package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;

import javafx.scene.image.Image;

import model.Faculty;
import model.Student;
import model.TMS;



public class TMSController extends Controller<Faculty>{
   
    
    public TMS tms;
    @FXML private TableView<Student> studentTv;
    @FXML private Label  totaltut;
    @FXML private Label  totalnetfee;
    @FXML private Label  totalbass;
    @FXML private Label  totalscholarship;
    @FXML private Label  totaldeduction;
    @FXML private Button CloseBtn;
    public Student student;
    
    
    public final Faculty getFaculty() {
        return model;
    }
    
    public void initialize(){
        stage.getIcons().add(new Image("view/uts.jpeg"));
        
        
        double total_tuition = 0;
        double total_netfee = 0;
        double total_bas = 0;
        double total_schol = 0;
        double total_deduct = 0;
        
        for (Student s : getFaculty().getStudents()) { //this is looping through the getStudents list and adding them all up. 
            total_tuition += s.getTotalFee(); // += is adding all the students into total tuition
            total_netfee += s.getNetFee();
            total_bas += (s.getScholarship() + s.getDeduction());
            total_schol += s.getScholarship();
            total_deduct += s.getDeduction();                  
        }
 
        String str_tut = Double.toString(total_tuition);
        totaltut.setText("$" + str_tut);
        
        String str_netfee = Double.toString(total_netfee);
        totalnetfee.setText("$" + str_netfee);
        
        String str_bas = Double.toString(total_bas);
        totalbass.setText("$" + str_bas);
        
        String str_schol = Double.toString(total_schol);
        totalscholarship.setText("$" + str_schol);
        
        String str_deduct = Double.toString(total_deduct);
        totaldeduction.setText("$" + str_deduct);

        
    }
    
    @FXML private void openClose(ActionEvent e) throws IOException{
        System.out.println("Ok button works");
        stage.close();
        
    }
    
}
    
    
    

