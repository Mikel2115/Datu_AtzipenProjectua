package dambi.accessingmongoumeak.model;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonProperty;



public class Bestseller {
    private int id;
    @BsonProperty("RANGO")
    private int rango;
    @BsonProperty("TITULO")
    private String titulo;
    @BsonProperty("VENTAS")
    private int ventas;
    @BsonProperty("SERIES")
    private String series;
    @BsonProperty("PLATAFORMA")
    private String plataforma;
    @BsonProperty("FECHA DE SALIDA")
    private Date fecha_de_salida;
    @BsonProperty("DESARROLLADOR")
    private String desarrollador;
    @BsonProperty("PUBLICADOR")
    private String publicador;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getRango(){
        return rango;
    }

    public void setRango(int rango){
        this.rango = rango;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String tituloa) {
        this.titulo = tituloa;
    }

    public int getVentas(){
        return ventas;
    }

    public void setVentas(int bentak){
        this.ventas = bentak;
    }

    public String getSeries(){
        return series;
    }

    public void setSeries(String seriea){
        this.series = seriea;
    }

    public String getPlataforma(){
        return plataforma;
    }

    public void setPlataforma(String plataforma){
        this.plataforma = plataforma;
    }

    public Date getFecha_de_salida() {
        return fecha_de_salida;
    }

    public void setFecha_de_salida(Date fecha_de_salida) {
        this.fecha_de_salida = fecha_de_salida;
    }

    public String getDesarrollador(){
        return desarrollador;
    }

    public void setDesarrollador(String desa){
        this.desarrollador = desa;
    }

    public String getPublicador(){
        return publicador;
    }

    public void setPublicador(String publi){
        this.publicador = publi;
    }

    @Override
    public String toString(){
        return "Bideojokoa["+id+", "+ rango +", "+ titulo +", "+ ventas + ", "+ series +", "+ plataforma + ", "+ fecha_de_salida +", "+ desarrollador +", "+ publicador +"]"; 
    }

   
    
}
