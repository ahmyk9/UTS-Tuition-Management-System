package model;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;




public class Faculty {

    private StringProperty name;
    private StringProperty email;
    private StringProperty password;
    private Students students;
 

    public Faculty(String name, String email, String password) {
        this.name = new SimpleStringProperty();
        this.name.set(name);
        this.email = new SimpleStringProperty();
        this.email.set(email);
        this.password = new SimpleStringProperty();
        this.password.set(password);
        students = new Students();
    }

    public Faculty() {
        this.students = new Students();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ReadOnlyStringProperty emailProperty() {
        return email;
    }

    public String getEmail() {
        return email.getValue();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ReadOnlyStringProperty passwordProperty() {
        return password;
    }

    public String getPassword() {
        return password.getValue();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    public boolean login(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    
    public ObservableList<Student> getStudents(){
        return this.students.getCurrentList();
    }
    
    public void addStudent(Student e){
        this.students.addStudent(e);
    }
    
    public boolean checkStudent(String name){
        return this.students.hasStudent(name);
    }
    
    public void removeStudent(Student e){
        this.students.remove(e);
    }
    
    public void filterList(String name, String email) {
        this.students.filterList(name, email);
    }


}
