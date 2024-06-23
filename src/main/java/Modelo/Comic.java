package Modelo;
import java.sql.Date;
public class Comic {
    private int comic_id;
    private int sucursal_id;
    private int editorial_id;
    private String editorial;
    private String ISBN;
    private String fotografia;
    private String titulo;
    private int num_pagina;
    private String sipnosis;
    private String formato;
    private Date fecha_edicion;
    private Double costo;
    private String ubicacion_estante;
    private int ejemplares;
    private String clasificacion;

    public int getComic_id() {
        return comic_id;
    }

    public void setComic_id(int comic_id) {
        this.comic_id = comic_id;
    }

    public int getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(int sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNum_pagina() {
        return num_pagina;
    }

    public void setNum_pagina(int num_pagina) {
        this.num_pagina = num_pagina;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Date getFecha_edicion() {
        return fecha_edicion;
    }

    public void setFecha_edicion(Date fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getUbicacion_estante() {
        return ubicacion_estante;
    }

    public void setUbicacion_estante(String ubicacion_estante) {
        this.ubicacion_estante = ubicacion_estante;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public Object[] Listado(){
        Object listar[]={comic_id,titulo,ejemplares,costo,ubicacion_estante};
        return listar;
    }
    
    public Object[] ListaInventario() {
        Object list[] = {comic_id,editorial,titulo,ubicacion_estante,clasificacion,formato,num_pagina,ejemplares,costo};
        return list;
    }

    public int getEditorial_id() {
        return editorial_id;
    }

    public void setEditorial_id(int editorial_id) {
        this.editorial_id = editorial_id;
    }
}
