package data;

import domain.Material;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class MaterialFile {

    //variables y atributos
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private ArrayList<Material> arrayList2;
    private ArrayList<Material> materials = new ArrayList<Material>();
    private File file = new File("./Materials.dat");

    //Método que recibe un material (libro o audiovisual) y lo escribe en el archivo 
    public void addMaterials(Material material) throws IOException {
        this.materials.add(material);
        this.oos = new ObjectOutputStream(new FileOutputStream(this.file));
        this.oos.writeObject(this.materials);
        this.oos.close();
    }

    //Métoddo que lee el archivo y guarda los materiales en un arrayList y lo retorna
    public ArrayList<Material> readFile() throws IOException, ClassNotFoundException {
        this.ois = new ObjectInputStream(new FileInputStream(this.file));
        this.arrayList2 = (ArrayList<Material>) this.ois.readObject();
        this.ois.close();

        return arrayList2;
    }
}
