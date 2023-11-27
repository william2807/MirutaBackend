package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Rutas")
public class Rutas {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    //    nombre de tabla, tamaño  ,  no puede ser nulo,   es unico , no se puede volver a modificar   
    @Column(name = "ruta", length = 5, nullable = false, unique = true, updatable = false)
    private String ruta_comercial;
    
    @Column(name = "linea", length = 6, nullable = false)
    private int linea;
    
    @Column(name = "tipo_servicio", length = 12, nullable = false)
    private String tipo_servicio;
    
    @Column(name = "operador", length = 32 ,nullable = false)
    private String operador;
    
    @Column(name = "inicio_final", length = 48,nullable = false)
    private String origen_destino;
    
    @Column(name = "inicio_recorrido",length = 4,nullable = false)
    private String zona_origen;
    
    @Column(name = "zona_destino", length = 4,nullable = false)
    private String zona_destino;

    public Rutas() {
    }
    
    public Rutas(Long  id,String ruta_comercial, int linea, String tipo_servicio, String operador, String origen_destino, String zona_origen, String zona_destino) {
        this.id = id;
        this.ruta_comercial = ruta_comercial;
        this.linea = linea;
        this.tipo_servicio = tipo_servicio;
        this.operador = operador;
        this.origen_destino = origen_destino;
        this.zona_origen = zona_origen;
        this.zona_destino = zona_destino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getRuta_comercial() {
        return ruta_comercial;
    }

    public void setRuta_comercial(String ruta_comercial) {
        this.ruta_comercial = ruta_comercial;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getOrigen_destino() {
        return origen_destino;
    }

    public void setOrigen_destino(String origen_destino) {
        this.origen_destino = origen_destino;
    }

    public String getZona_origen() {
        return zona_origen;
    }

    public void setZona_origen(String zona_origen) {
        this.zona_origen = zona_origen;
    }

    public String getZona_destino() {
        return zona_destino;
    }

    public void setZona_destino(String zona_destino) {
        this.zona_destino = zona_destino;
    }
    
}