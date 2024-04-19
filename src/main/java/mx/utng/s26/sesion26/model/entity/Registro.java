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
@Table(name = "registros")
public class Registro {
//ID
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //FECHAINICIO
@DateTimeFormat(pattern = "yyyy-MM-dd") // Specify the expected date format
private Date recordAt;

    @Column(length = 40, nullable = false)
    @NotEmpty
    private String usuario;

//DESCRIPCION
    @Column (length = 200, nullable = false)
    @NotEmpty
    private String actividad;    

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String resultado;



    public Long getId() {
        return id;
    }





    public void setId(Long id) {
        this.id = id;
    }





    public Date getRecordAt() {
        return recordAt;
    }





    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }





    public String getUsuario() {
        return usuario;
    }





    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }





    public String getActividad() {
        return actividad;
    }





    public void setActividad(String actividad) {
        this.actividad = actividad;
    }





    public String getResultado() {
        return resultado;
    }





    public void setResultado(String resultado) {
        this.resultado = resultado;
    }




    
    






}

//Falta y getter y setter de Grupo y constructor asi como sus adornos