package model;


public class Session {
    private Faculty faculty;
    private Faculties faculties;
    
    public Session(){
        this.faculties = new Faculties(); 
        this.faculty = new Faculty();
    }
 
    public Faculty getFaculty(String email, String password){
        return faculties.getFaculty(email, password);
    }
    
    public void setFaculty(Faculty e){
        this.faculty = e;
    }

}
