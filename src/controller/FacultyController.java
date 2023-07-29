package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;



public class FacultyController extends Controller<Faculty>{
    
    private Student student = new Student("","","","","","",0,0,"");
    
    
    //textfields
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    
    //list view
    @FXML private TableView<Student> studentTv;
    
    
    //Buttons
    @FXML private Button AddBtn;
    @FXML private Button DeleteBtn;
    @FXML private Button SelectBtn;
    @FXML private Button SLIPBtn;
    @FXML private Button ReportBtn;
    @FXML private Button CloseBtn;
    
    
    
    public void initialize(){
        studentTv.getSelectionModel().selectedItemProperty().addListener(
                (observable) -> DeleteBtn.setDisable(observable == null)
        );
        
        /*
        studentTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> DeleteBtn.setDisable(observable == null)
        );
        */
        
        studentTv.getSelectionModel().selectedItemProperty().addListener(
                (observable) -> SelectBtn.setDisable(observable == null)
        );
        studentTv.getSelectionModel().selectedItemProperty().addListener(
                (observable) -> SLIPBtn.setDisable(observable == null)
        );
        stage.getIcons().add(new Image("view/faculty.png"));
    }
    
    public final Faculty getFaculty(){
        return model;
    }
    
    
    
    private Student getSelectedStudent() {
        return studentTv.getSelectionModel().getSelectedItem();
    }
  
    //Button Functions
    
    @FXML private void openAdd(ActionEvent e) throws Exception{
        System.out.println("Add button works");
        Student student = new Student("","","","","","",0,0,"");
        student.setFaculty(getFaculty());
        ViewLoader.showStage(student ,"/view/student.fxml", "Adding New Student" , new Stage());  
        
    }
    
    @FXML private void openDelete(ActionEvent e) throws Exception{
        getFaculty().removeStudent(getSelectedStudent());
        System.out.println("Delete button works");
        
    }
    

    @FXML private void openSelect(ActionEvent e) throws Exception{
        System.out.println("Select button works");
        Student student = getSelectedStudent();
        student.setFaculty(getFaculty());
        ViewLoader.showStage(student ,"/view/student.fxml", "Accessing File: " + student.getName(), new Stage());
  
    }

    
    @FXML private void openSLIP(ActionEvent e) throws Exception{
        System.out.println("SLIP button works");
        Student student = getSelectedStudent();
        student.setFaculty(getFaculty());
        ViewLoader.showStage(student ,"/view/slip.fxml", student.getName() + " Slip Report" , new Stage());
        
    }
    
    @FXML private void openReport(ActionEvent e) throws Exception{
        System.out.println("Report button works");
        ViewLoader.showStage(getFaculty() ,"/view/tms.fxml", "TMS Report", new Stage());
    }
    
    @FXML private void openClose(ActionEvent e) throws Exception{
        System.out.println("Close button works");
        stage.close();
    }
    
}
