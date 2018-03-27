package data;

import domain.Loan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class LoanFile {
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private ArrayList<Loan> arrayList;
    private ArrayList<Loan> loans = new ArrayList<Loan>();
    private File file = new File("./Loans.dat");
    
    //Método que recibe un Prestamo y lo escribe en el archivo 
    public void addMaterials(Loan loan) throws IOException{
        this.loans.add(loan);
        this.oos = new ObjectOutputStream(new FileOutputStream(this.file));
        this.oos.writeObject(this.loans);
        this.oos.close();
    }
    //Métoddo que lee el archivo de prestamos y guarda los prestamos en un arrayList y lo retorna
    public ArrayList<Loan> readFile() throws IOException, ClassNotFoundException{
       this.ois = new ObjectInputStream(new FileInputStream(this.file));
       this.arrayList = ( ArrayList <Loan> )this.ois.readObject();
       this.ois.close();
       return arrayList;
    }
}
