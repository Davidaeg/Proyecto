package data;

import domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class StudentFile {

    //Atributos
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registros en el archivo
    private int regSize;//tamanno del registro
    private String myFilePath;//ruta

    //constructor
    public StudentFile(File file) throws IOException {
        //almaceno la ruta
        myFilePath = file.getPath();
        //indico el tamanno m'aximo
        this.regSize = 120;

        //una validaci'on sencilla
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + " is an invalid file");
        } else {
            //crear la nueva instancia de RAF
            randomAccessFile = new RandomAccessFile(file, "rw");

            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int) Math.ceil((double) randomAccessFile.length() / (double) regSize);
        }
    }//end method

    //MUY IMPORTANTE cerrar nuestros archivos
    public void close() throws IOException {
        randomAccessFile.close();
    }

    //indicar la cantidad de registros de nuestro archivo
    public int fileSize() {
        return this.regsQuantity;
    }

    //insertar un nuevo registro en una posici'on espec'ifica
    public boolean putValue(int position, Student student) throws IOException {
        //primero: verificar que sea v'alida la inserci'on
        if (position < 0 && position > this.regsQuantity) {
            System.err.println("1001 - Record position is out of bounds");
            return false;
        } else {
            if (student.sizeInBytes() > this.regSize) {
                System.err.println("1002 - Record size is out of bounds");
                return false;
            } else {
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(student.getName());
                randomAccessFile.writeInt(student.getYear());
                randomAccessFile.writeUTF(student.getMajor());
                randomAccessFile.writeUTF(student.getId());
                return true;
            }
        }
    }//end method

    //insertar al final del archivo
    public boolean addEndRecord(Student student) throws IOException {
        boolean success = putValue(this.regsQuantity, student);
        if (success) {
            ++this.regsQuantity;
        }
        return success;
    }

    //obtener un estudiante
    public Student getStudent(int position) throws IOException {
        //validar la posici'on
        if (position >= 0 && position <= this.regsQuantity) {
            //colocamos el brazo en el lugar adecuado
            randomAccessFile.seek(position * this.regSize);

            //llevamos a cabo la lectura
            Student studentTemp = new Student();
            studentTemp.setName(randomAccessFile.readUTF());
            studentTemp.setYear(randomAccessFile.readInt());
            studentTemp.setMajor(randomAccessFile.readUTF());
            studentTemp.setId(randomAccessFile.readUTF());

            if (studentTemp.getName().equalsIgnoreCase("deleted")) {
                return null;
            } else {
                return studentTemp;
            }
        } else {
            System.err.println("1003 - position is out of bounds");
            return null;
        }
    }//end method

    //retornar una lista de estudiantes
    public ArrayList<Student> getAllStudents() throws IOException {
        ArrayList<Student> studentsArray = new ArrayList<Student>();

        for (int i = 0; i < this.regsQuantity; i++) {
            Student sTemp = this.getStudent(i);

            if (sTemp != null) {
                studentsArray.add(sTemp);
            }
        }//end for
        return studentsArray;
    }

    //comprueba con el carné si el estudiante está registrado o no
    public boolean checkId(String iD) throws IOException {

        boolean success = false;
        Student student;

        for (int i = 0; i < this.regsQuantity; i++) {
            student = this.getStudent(i);
            if(student.getId().equalsIgnoreCase(iD)){
                success = true;
                break;
            }            
        }
        
        return success;
    }// fin checkId
}
