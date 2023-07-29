package model;

import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class TMS {
    private DoubleProperty totalTuitionFee;
    private DoubleProperty totalScholarship;
    private DoubleProperty totalNetFee;
    private DoubleProperty totalDeduction;
    private DoubleProperty bas;
    private ObservableList<Student> students ;
    private ObservableList<Report> reports;
    
    public TMS(Faculty faculty){
        this.students = faculty.getStudents();
        this.reports = FXCollections.<Report>observableArrayList();
        createTMS();        
        this.totalTuitionFee = new SimpleDoubleProperty();  
        this.totalTuitionFee.set(getTotalTuitionFee());
        this.totalScholarship = new SimpleDoubleProperty();  
        this.totalScholarship.set(getTotalScholarship());
        this.totalDeduction = new SimpleDoubleProperty();
        this.totalDeduction.set(getTotalDeduction());
        this.totalNetFee = new SimpleDoubleProperty();  
        this.totalNetFee.set(getTotalNetFee());
        this.bas = new SimpleDoubleProperty();
        this.bas.bind(totalDeduction.add(totalScholarship));
    }
    
    private void createTMS(){
        getStudents().forEach(e -> {
            reports.add(new Report(e));
        });
    }
    
    public ReadOnlyDoubleProperty totalTuitionFeeProperty() {
        return totalTuitionFee;
    } 
    
    public double getTotalTuitionFee(){
        double total = 0;
        return getStudents().stream().map(e -> e.getTotalFee()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }
    
    public ReadOnlyDoubleProperty totalScholarshipProperty() {
        return totalScholarship;
    } 
    
    public double getTotalScholarship(){
        double total = 0;
        return getStudents().stream().map(e -> e.getScholarship()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }
    
    public ReadOnlyDoubleProperty totalNetFeeProperty() {
        return totalNetFee;
    } 
    
    public double getTotalNetFee(){
        double total = 0;
        return getStudents().stream().map(e -> e.getNetFee()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }
    
    public ReadOnlyDoubleProperty totalDeductionProperty() {
        return totalDeduction;
    } 
    
    public double getTotalDeduction(){
        double total = 0;
        return getStudents().stream().map(e -> e.getDeduction()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }   
    
    public ReadOnlyDoubleProperty basProperty() {
        return bas;
    } 
    
    public double getBas(){
        return bas.get();
    }
    
    public ObservableList<Student> getStudents(){
        return this.students;
    }
    
    public ObservableList<Report> reports(){
        return this.reports;
    }
    
    
}
