package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import model.Student;



public class SlipController  extends Controller<Student>{
    
    
//button
    public Student student;
    @FXML private Button CloseBtn;
    @FXML private Label  creditsDIS;
    @FXML private Label  TotalFeeDIS;
    @FXML private Label  netfeeDIS;
    @FXML private Label  PayPerCreditDIS;
    @FXML private Label  scholarshDIS;
    @FXML private Label  deductDIS;



    public void initialize(){
       stage.getIcons().add(new Image("view/edit.png"));
       
             
       String str_credit = Double.toString(getStudent().getCredits());
       creditsDIS.setText(str_credit + " credits");
       
       String str_totalfee = Double.toString(getStudent().getTotalFee());
       TotalFeeDIS.setText("$" + str_totalfee);
       
       String str_netfee = Double.toString(getStudent().getNetFee());
       netfeeDIS.setText("$" + str_netfee);
       
       String str_schol = Double.toString(getStudent().getScholarship());
       scholarshDIS.setText("$" + str_schol);
       
       String str_tutionslip = Double.toString(getStudent().getDeduction());
       deductDIS.setText("$" + str_tutionslip);
       
       String str_paypercredit = Double.toString(getStudent().getPayPerCredit());
       PayPerCreditDIS.setText("$" + str_paypercredit);
     
    }
    
    
    public final Student getStudent(){
        return model;
    }
    
    
    @FXML private void openClose(ActionEvent e) throws Exception{
        System.out.println("Close button works");
        stage.close();
    }

    




}

