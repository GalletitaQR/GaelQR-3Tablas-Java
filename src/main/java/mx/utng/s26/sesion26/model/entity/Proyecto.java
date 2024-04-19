package mx.utng.s26.sesion26.model.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "proyects")
public class Proyecto {
//ID
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//NOMBRE
    @Column(length = 40, nullable = false)
    @NotEmpty
    private String nombre;

//DESCRIPCION
    @Column (length = 200, nullable = false)
    @NotEmpty
    private String descripcion;

//FECHAINICIO
@DateTimeFormat(pattern = "yyyy-MM-dd") // Specify the expected date format
    private Date recordAt;

    

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String estado;




    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }






}

//Falta y getter y setter de Grupo y constructor asi como sus adornos