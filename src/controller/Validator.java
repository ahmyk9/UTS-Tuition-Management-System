package controller;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator{
    private LinkedList<String> errors;
    private final String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private final String namePattern = "^[A-Z][a-zA-Z ]+[A-Z][a-zA-Z]+$";
    private final String phonePattern = "^[0-9]{8}$";
    private final String addressPattern = "^[0-9]+( )[A-Z][a-zA-Z. ]+[A-Z]?[a-zA-Z0-9]+$";
    private final String typePattern = "^[A-Z][a-z]+[-]?[A-Z]?[a-z]*$";
    private final String IDPattern = "^[0-9]{8}$";
    
   
    public Validator(){    
        this.errors = new LinkedList<>();
    }
    
    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    
    public boolean isEmpty(String input) {
        return input.isEmpty();
    }
    
    public void generateErrors(String name, String email, String phone,String address,String type, String ID, int credits, double scholarship){
        if(!validate(namePattern,name))
            addError("Incorrect name pattern!\n");
        if(!validate(emailPattern,email))
            addError("Incorrect email pattern!\n");
        if(!validate(phonePattern,phone))
            addError("Incorrect phone pattern!\n");
        if(!validate(addressPattern,address))
            addError("Incorrect address pattern!\n");
        if(!validate(typePattern,type))
            addError("Incorrect type pattern!\n");
        if(!validate(IDPattern,ID))
            addError("Incorrect ID pattern!\n");
        if(credits%6!=0||credits<0)
            addError("Incorrect credits number!\n");
        if(scholarship<0 || scholarship >100000)
            addError("Incorrect scholarship number!\n");
    }
    
    public boolean isValid(String name, String email, String phone,String address,String type, String ID, int credits, double scholarship){
        return validate(namePattern,name) 
                && validate(emailPattern,email) 
                && validate(phonePattern,phone) 
                && validate(addressPattern,address) 
                && validate(typePattern,type)
                && validate(IDPattern,ID)
                && !(credits%6!=0||credits<0)
                && !(scholarship<0 || scholarship >100000); 
    }
    
    public void addError(String msg){
        this.errors.add(msg);
    }
    
    public LinkedList<String> errors(){
        return this.errors;
    }
    
    public void clear(){
        this.errors.clear();
    }
}
