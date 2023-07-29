package model;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

    
    private StringProperty name;
    private StringProperty email;
    private StringProperty phone;
    private StringProperty address;
    private StringProperty ID;
    private StringProperty type; 
    private IntegerProperty credits;
    private DoubleProperty payPerCredit;
    private DoubleProperty totalFee;
    private DoubleProperty scholarship;
    private DoubleProperty netFee;
    private DoubleProperty deduction;
    private DoubleProperty deductionRate;
    private Faculty faculty;

    public Student(String name, String email, String phone, String address, String ID, String type, int credits, double scholarship, String deductionCode) {
        this.name = new SimpleStringProperty();
        this.name.set(name);
        this.email = new SimpleStringProperty();
        this.email.set(email);
        this.phone = new SimpleStringProperty();
        this.phone.set(phone);
        this.address = new SimpleStringProperty();
        this.address.set(address);
        this.ID = new SimpleStringProperty();
        this.ID.set(ID);
        this.type = new SimpleStringProperty();
        this.type.set(type);
        this.credits = new SimpleIntegerProperty();
        this.credits.set(credits);
        this.payPerCredit = new SimpleDoubleProperty();
        this.payPerCredit.set(500.00);     
        this.totalFee = new SimpleDoubleProperty();
        this.totalFee.bind(this.credits.multiply(this.payPerCredit));
        this.scholarship = new SimpleDoubleProperty();
        this.scholarship.set(scholarship);
        this.deductionRate = new SimpleDoubleProperty();
        this.deductionRate.set(0.10);
        this.deduction = new SimpleDoubleProperty();
        if (deductionCode.equals("2022AUT"))
        this.deduction.bind(this.totalFee.multiply(this.deductionRate));
        else 
        this.deduction.set(0.00);
        this.netFee = new SimpleDoubleProperty();
        this.netFee.bind(this.totalFee.subtract(deduction).subtract(scholarship));
    }

    public void updateDetails(String name, String email, String phone, String address, String ID, String type, int credits, double scholarship, String deductionCode){       
        this.name.set(name);    
        this.email.set(email);        
        this.phone.set(phone);     
        this.address.set(address);        
        this.ID.set(ID);    
        this.type.set(type);
        this.credits.set(credits);        
        this.scholarship.set(scholarship);
        if (deductionCode.equals("2022AUT"))
            this.deduction.bind(this.totalFee.multiply(this.deductionRate));
        else 
            this.deduction.set(0.00);
    }
    
    public void setFaculty(Faculty e){
        this.faculty = e;
    }
    
    public Faculty getFaculty(){
        return this.faculty;
    }
    
    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public String getName(){
        return name.getValue();
    }
    
    public ReadOnlyStringProperty emailProperty() {
        return email;
    }

    public String getEmail(){
        return email.getValue();
    }
    
    public ReadOnlyStringProperty phoneProperty() {
        return phone;
    }

    public String getPhone(){
        return phone.getValue();
    }
    
    public ReadOnlyStringProperty addressProperty() {
        return address;
    }

    public String getAddress(){
        return address.getValue();
    }
    
    public ReadOnlyStringProperty IDProperty() {
        return ID;
    }

    public String getID(){
        return ID.getValue();
    }
    
    public ReadOnlyStringProperty typeProperty() {
        return type;
    }

    public String getType(){
        return type.getValue();
    }
    
    public IntegerProperty creditsProperty() {
        return credits;
    }
    
    public int getCredits(){
        return credits.get();
    }

    public ReadOnlyDoubleProperty payPerCreditProperty() {
        return payPerCredit;
    }    
    
    public double getPayPerCredit(){
        return payPerCredit.get();
    }
    
    public ReadOnlyDoubleProperty totalFeeProperty() {
        return totalFee;
    }    
    
    public double getTotalFee(){
        return totalFee.get();
    }
    
    public ReadOnlyDoubleProperty netFeeProperty() {
        return netFee;
    }    
    
    public double getNetFee(){
        return netFee.get();
    }
    
    public ReadOnlyDoubleProperty scholarshipProperty() {
        return scholarship;
    }    
    
    public double getScholarship(){
        return scholarship.get();
    }
    
    public ReadOnlyDoubleProperty deductionProperty() {
        return deduction;
    }    
    
    public double getDeduction(){
        return deduction.get();
    }
    
    public ReadOnlyDoubleProperty deductionRateProperty() {
        return deductionRate;
    }    
    
    public double getDeductionRate(){
        return deductionRate.get();
    }
    
    public boolean hasName(String name){
        return getName().toLowerCase().contains(name.toLowerCase().trim());
    } 
    
    public boolean hasEmail(String email){
        return getEmail().toLowerCase().contains(email.toLowerCase().trim());
    }

}
