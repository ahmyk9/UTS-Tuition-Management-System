package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Faculties {
    private final ObservableList<Faculty> faculties;

    public Faculties() {
        faculties = FXCollections.observableArrayList(
                new Faculty("John Smith", "john.smith@uts.com", "user222"),
                new Faculty("Jane Tyler", "jane.tyler@uts.com", "super123")
        );      
    }
   
    public boolean hasFaculty(String name, String password) {
        return faculties.stream().anyMatch(p -> (p.login(name, password)));
    }

    public Faculty getFaculty(String name, String password){
        for(Faculty e:faculties)
            if(e.login(name, password))
                return e;
        return null;
    }   
    
    
}

