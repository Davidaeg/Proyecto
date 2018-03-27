package domain;

import java.io.Serializable;

/**
 *
 * @author David
 */
public class Material implements Serializable{
    private String name;
    private int code;

    public Material() {
        this.name = "";
        this.code = 0;
    }

    public Material(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Material{" + "nombre: " + name + ", codigo: " + code ;
    }
    
}
