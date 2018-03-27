/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.MaterialFile;
import domain.AudioVisualMaterial;
import domain.Book;
import domain.Material;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bryan Keihl
 */
public class Prueba {
    
    public Prueba() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws IOException, ClassNotFoundException {
        MaterialFile mf = new MaterialFile();
        Material book = new Book("Cocori", 2012, "c", 3215, true, "C");
        Material au = new AudioVisualMaterial("Monitor", "hs", 6445, true);
        Material sfsaf = new AudioVisualMaterial("Mouse", "fewfw", 64, true);
        
        mf.addMaterials(book);
        mf.addMaterials(au);
        mf.addMaterials(sfsaf);
        
        ArrayList<Material> m = mf.readFile();
        
        for(int i = 0;i<m.size();i++){
            System.out.println(m.get(i));
        }
         
    }
}
