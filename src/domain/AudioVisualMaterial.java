package domain;

/**
 *
 * @author David
 */
public class AudioVisualMaterial extends Material {
    //Atributos
    private String description;
    private boolean enable;
    
    //Constructores
    public AudioVisualMaterial() {
        super();
        this.description = "";
        this.enable = false;
    }

    public AudioVisualMaterial(String name, String description, int code, boolean enable) {
        super(name, code);
        this.description = description;
        this.enable = enable;
    }
    //Accesores
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Audiovisial, " +super.getName()+", descripción: " + description 
                + ", code: " + super.getCode() + ", disponible: " + enable;
    }
    
    
}
