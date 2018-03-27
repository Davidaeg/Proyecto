package domain;



/**
 *
 * @author David
 */
public class Book extends Material {
    //Atributos
    private int year;
    private String author;
    private boolean enable;
    private String format;
    //constructores
    public Book() {
        super();
        this.year = 0;
        this.author = "";
        this.enable = false;
        this.format = "";
    }

    public Book(String name, int year, String author, int isbn, boolean enable, String format) {
        super(name,isbn);
        this.year = year;
        this.author = author;
        this.enable = enable;
        this.format = format;
    }
    //Accesores
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enaable) {
        this.enable = enable;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Libro " +super.getName()+", año: " + year + ", autor: " + author 
                +", isbn: "+super.getCode()+", disponible: " + enable + ", formato: " + format;
    }
    
    
}                                                        