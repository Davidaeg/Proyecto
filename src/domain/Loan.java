package domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author David
 */
public class Loan implements Serializable {
    //Atributos
    private Student student;
    private Material material;
    private Calendar returnDay;
    private int tax;

    //Constructores
    public Loan() {
        this.student = new Student();
        this.material = new Material();
        this.returnDay = new GregorianCalendar();
        this.tax = 0;
    }

    public Loan(Student student, Material material, Calendar returnDay, int tax) {
        this.student = student;
        this.material = material;
        this.returnDay = returnDay;
        this.tax = tax;
    }
    //Accesores
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Calendar getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Calendar returnDay) {
        this.returnDay = returnDay;
    }
      public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Loan{" + "student: " + student.toString() + ", material=" + material.toString() + ", calendar=" + returnDay + '}';
    }
    
    public int checkTax(Calendar deliveredDay){
        if(deliveredDay.after(this.returnDay)){
            this.tax += 5;
            return this.tax;
        }else{
            return this.tax;
        }
    }
    
}
