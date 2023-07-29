package model;


import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Students {

    private ObservableList<Student> students;
    private ObservableList<Student> current;

    public Students() {
        current = FXCollections.<Student>observableArrayList();
        students = FXCollections.observableArrayList(
                new Student("Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", "13697480", "Full-Time", 48, 4000, ""),
                new Student("Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", "14517880", "Part-Time", 24,0, ""),
                new Student("Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", "13267102", "Full-Time", 48,0, "2022AUT"),
                new Student("Andreas Brehme", "andreas.b@uts.com", "90001222", "91 Sussex St. Sydney 2100", "13678020", "Full-Time", 48,0, ""),
                new Student("Ruddy Voller", "ruddy.v@uts.com", "98980000", "15 Stan St. Sydney 2100", "13972870", "Full-Time", 48,8000, ""),
                new Student("Monica Shwarz", "monica.s@uts.com", "92241188", "155 Jones St. Sydney 2001", "13859610", "Part-Time", 24,0, "2022AUT")
        );
        current.addAll(students);
        students.addListener(new ListChangeListener<Student>() {
            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Student> c) {
                current.clear();
                current.addAll(students);
            }
        });
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudent(String name, String email, String phone, String address, String ID, String type, int credits, double scholarship, String deductionCode) {
        students.add(new Student(name,email,phone,address,ID,type,credits,scholarship, deductionCode));
    }
    
    public boolean hasStudent(String name) {
        for(Student e:students)
            if(e.hasName(name)&& !name.isEmpty())
                return true;
        return false;
    }
    
    public Student getStudent(String name){
        for(Student p: students)
            if(p.hasName(name))
                return p;
        return null;                        
    }

    public void remove(Student p) {
        this.students.remove(p);
    }

    public void remove(List<Student> selectedItems) {
        this.students.removeAll(selectedItems);
    }

    public void addStudents(List<Student> selectedItems) {
        this.students.addAll(selectedItems);
    }

    public ObservableList<Student> getCurrentList() {
        return this.current;
    }

    
 
    
    
    
    public void filterList(String name, String email) {

        List<Student> temp = new ArrayList<>();

        students.forEach((Student p) -> {
            try {
                if ((p.hasName(name)) || (p.hasEmail(email))) {
                    temp.add(p);
                }
            } catch (NumberFormatException e) {
            }
        });

        this.current.clear();
        this.current.addAll(temp);
    }
    

}
