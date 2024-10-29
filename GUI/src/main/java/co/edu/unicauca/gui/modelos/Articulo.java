package co.edu.unicauca.gui.modelos;

public class Articulo {
    private int id;
    private String titulo;
    private String autores[];
    private int cantAutores;
    private String revista;
  
    public Articulo() {
    }

    public Articulo(String nombre, String[] autores, String revista,Conferencia conf) {
        this.id = 0;
        this.titulo = nombre;
        this.autores = autores;
        this.cantAutores = autores.length;
        this.revista = revista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nombre) {
        this.titulo = nombre;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public int getCantAutores() {
        return cantAutores;
    }

    public void setCantAutores(int cantAutores) {
        this.cantAutores = cantAutores;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }
    
   
   
}
