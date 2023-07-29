package controller;

import au.edu.uts.ap.javafx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import model.Student;



public class StudentController extends Controller<Student>{
    
    
    //textfields
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField studentidTf;
    @FXML private TextField typeTf;
    @FXML private TextField creditTf;
    @FXML private TextField scholarTf;
    @FXML private TextField deductTf;
    @FXML private TableView<Student> studentTv;
    
    

    
    
    //getters (from textfield to code)
    private String getName(){
        return nameTf.getText();
        
    }
    
    private String getEmail(){
        return emailTf.getText();
    }
    
    private String getPhone(){
        return phoneTf.getText();
    }
    
    private String getAddress(){
        return addressTf.getText();
    }
    
    private String getStudentID(){
        return studentidTf.getText();
    }
    
    private String getType(){
        return typeTf.getText();
    }
    
    private int getCredit(){
        int number = Integer.parseInt(creditTf.getText());
        return number;
    }
    
    private double getScholar(){
        double number = Double.parseDouble(scholarTf.getText());
        return number;
    }
    
    private String getDeduct(){
        
        return deductTf.getText();
    }
    
    
    //setters (from code  to textfield)
    
    //for the update button to work and actually update
    public  void selectButtonRunner(){
        cName(getStudent().getName());
        cEmail(getStudent().getEmail());
        cPhone(getStudent().getPhone());
        cAddress(getStudent().getAddress());
        cStudentID(getStudent().getID());
        cType(getStudent().getType());
        cCredits(Integer.toString(getStudent().getCredits()));
        cScholarship(Double.toString(getStudent().getScholarship()));
        cDeduct(Double.toString(getStudent().getDeduction()));
        
    }
    
    private void cName(String txt){ 
        nameTf.setText(txt);
    }
    
    private void cEmail(String txt){ 
        emailTf.setText(txt);
    }
    
    private void cPhone (String txt){ 
        phoneTf.setText(txt);
    }
    
    private void cAddress (String txt){ 
        addressTf.setText(txt);
    }
    
    private void cStudentID (String txt){ 
        studentidTf.setText(txt);
    }
    
    private void cType (String txt){ 
        typeTf.setText(txt);
    }
    
    private void cCredits (String txt){ 
        int a = Integer.parseInt(txt);
        String s = Integer.toString(a);
        creditTf.setText(s);
        
        //Integer.parseInt(str);
    }
    
    private void cScholarship(String txt){ 
        double a = Double.parseDouble(txt);
        String s = Double.toString(a);
        scholarTf.setText(s);
    }
    
    private void cDeduct(String txt){
        double a = Double.parseDouble(txt);
        String s = Double.toString(a);
        deductTf.setText(s);
    }
    
    
    
    //Buttons
    @FXML private Button AddBtn;
    @FXML private Button UpdateBtn;
    @FXML private Button CancelBtn;
    
    
   

    public final Student getStudent() {
        return model;
    }
    
    
    public void initialize(){
        
        stage.getIcons().add(new Image("view/edit.png"));
        selectButtonRunner();

    }
    
    
    
    
    
    @FXML private void openAdd(ActionEvent e) throws Exception{  
        System.out.println("Add button works");
        Student student = new Student(getName(),getEmail(),getPhone(),getAddress(),getStudentID(),getType(),getCredit(),getScholar(),getDeduct());
        getStudent().getFaculty().addStudent(student);
        stage.close();
    }
    
    @FXML private void openUpdate(ActionEvent e) throws Exception{
        System.out.println("Update button works");
    
        Student new_student = new Student(getName(),getEmail(),getPhone(),getAddress(),getStudentID(),getType(),getCredit(),getScholar(),getDeduct());
        
        
        Student old_student = null;
        int i = 0;
        // Find index i
        for (Student s : getStudent().getFaculty().getStudents()) { //this is looping through the list of students
            if (s.getName().equals(getStudent().getName()))   { //checking if its the correct student
                break;
            }   
            i++;
        }
        
        // Replace student at index i with form student details
        getStudent().getFaculty().getStudents().set(i, new_student);
        stage.close();
       
    }
    
    @FXML private void openClose(ActionEvent e) throws Exception{
        System.out.println("Close button works");
        stage.close();
        
    }


    
}
