package domain;


/**
 *
 * @author David
 */
public class Student{
    //Atrubutos
    private String name;
    private int year;
    private String major;
    private String id;
    private static int AGROCOUNTER = 0;
    private static int INFOCOUNTER = 0;
    private static int EDUCOUNTER = 0;
    //Constructores
    public Student() {
        this.name = "";
        this.year = 0;
        this.major = "";
        this.id = "";
    }
    
    public Student(String name, int year, String carrera) {
        this.name = name;
        this.year = year;
        this.major = carrera;
        this.id = "";
    }
    //Accesores
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Nombre: " + this.name + ", carrera: " + this.major + ", Carnet: " +this.id;
    }
    
    public int sizeInBytes(){
        //int: necesita 4 bytes
        //String: necesita 2 bytes de espacio, cada variable String se multiplica su length por 2.
        return this.getName().length() * 2 + this.getMajor().length() * 2 
                +this.getId().length()*2 + 4;
    }
    /* Método que genéra el Id, compara la letra inicial de la carrera, al encontrarla concatena a
     * id esa letra tl último numero del año en que entró y la variable estatica aumentada*/ 
     public void newId(){
        String letter = String.valueOf(this.major.charAt(0));
        if(letter.equalsIgnoreCase("A")) {
            AGROCOUNTER++;
            this.id = letter+this.year%10+String.format("%03d",AGROCOUNTER);
        }
        if(letter.equalsIgnoreCase("I")){
            INFOCOUNTER++;
            this.id = letter+this.year%10+String.format("%03d",INFOCOUNTER);
        }
         if(letter.equalsIgnoreCase("E")){
            EDUCOUNTER++;
            this.id = letter+this.year%10+String.format("%03d",EDUCOUNTER);
        }
        
    }
}
