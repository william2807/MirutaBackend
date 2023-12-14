package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    
    @Getter
    @Setter
    @Column(name = "nombres", length = 62, nullable = false, unique = true, updatable = false)
    private String Nombres;
    
    @Getter
    @Setter
    @Column(name = "apellidos", length = 62, nullable = false, unique = true, updatable = false)
    private String Apellidos;
    
    @Getter
    @Setter
    @Column(name = "Correo_electronico", length = 62, updatable = true)
    private String Correo_electronico;
    
    @Getter
    @Setter
    @Column(name = "Tarjeta_sitp", length = 15, updatable = true)
    private String Tarjeta_sitp;
    
    @Getter
    @Setter
    @Column(name = "telefono", length = 12, updatable = true)
    private String Telefono;
    
    @Getter
    @Setter
    @Column(name = "fecha_nacimiento", unique = true, updatable = false)
    private Date fecha_Nacimiento;

    public Usuario() {
    }

    public Usuario(String Id, String Nombres, String Apellidos, String Correo_electronico, String Tarjeta_sitp, String Telefono, Date fecha_Nacimiento) {
        this.Id = Id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Correo_electronico = Correo_electronico;
        this.Tarjeta_sitp = Tarjeta_sitp;
        this.Telefono = Telefono;
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

       
}
