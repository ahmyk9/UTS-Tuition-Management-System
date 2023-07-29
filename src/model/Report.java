package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Report {

    private StringProperty name;
    private DoubleProperty totalFee;
    private DoubleProperty scholarship;
    private DoubleProperty netFee;
    private DoubleProperty deduction;

    public Report(Student e) {
        this.name = new SimpleStringProperty();
        this.name.set(e.getName());
        this.totalFee = new SimpleDoubleProperty();
        this.totalFee.set(e.getTotalFee());
        this.scholarship = new SimpleDoubleProperty();
        scholarship.set(e.getScholarship());
        this.netFee = new SimpleDoubleProperty();
        netFee.set(e.getNetFee());
        this.deduction = new SimpleDoubleProperty();
        deduction.set(e.getDeduction());
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.getValue();
    }

    public ReadOnlyDoubleProperty totalFeeProperty() {
        return totalFee;
    }

    public double getTotalFee() {
        return totalFee.get();
    }

    public ReadOnlyDoubleProperty scholarshipProperty() {
        return scholarship;
    }

    public double getScholarship() {
        return scholarship.get();
    }

    public ReadOnlyDoubleProperty netFeeProperty() {
        return netFee;
    }

    public double getNetFee() {
        return netFee.get();
    }

    public ReadOnlyDoubleProperty deductionProperty() {
        return deduction;
    }

    public double getDeduction() {
        return deduction.get();
    }
   
}
