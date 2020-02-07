package Entidad;
// Generated 01/12/2019 10:14:18 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="cliente"
    ,catalog="transporte"
)
public class Cliente  implements java.io.Serializable {


     private String dni;
     private Distrito distrito;
     private String nombres;
     private String apellidos;
     private String direccion;
     private boolean sexo;
     private boolean estadoCivil;
     private String telefono;
     private String correoElectronico;
     private String nacionalidad;
     private Date fechaNacimiento;

    public Cliente() {
    }

	
    public Cliente(String dni, Distrito distrito, String nombres, String apellidos, String direccion, boolean sexo, boolean estadoCivil, Date fechaNacimiento) {
        this.dni = dni;
        this.distrito = distrito;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Cliente(String dni, Distrito distrito, String nombres, String apellidos, String direccion, boolean sexo, boolean estadoCivil, String telefono, String correoElectronico, String nacionalidad, Date fechaNacimiento) {
       this.dni = dni;
       this.distrito = distrito;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.direccion = direccion;
       this.sexo = sexo;
       this.estadoCivil = estadoCivil;
       this.telefono = telefono;
       this.correoElectronico = correoElectronico;
       this.nacionalidad = nacionalidad;
       this.fechaNacimiento = fechaNacimiento;
    }
   
     @Id 

    
    @Column(name="dni", unique=true, nullable=false, length=8)
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="lugar_nacimiento", nullable=false)
    public Distrito getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    
    @Column(name="nombres", nullable=false, length=50)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    @Column(name="apellidos", nullable=false, length=80)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    @Column(name="direccion", nullable=false, length=100)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="sexo", nullable=false)
    public boolean isSexo() {
        return this.sexo;
    }
    
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    
    @Column(name="estado_civil", nullable=false)
    public boolean isEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(boolean estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    
    @Column(name="telefono", length=15)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="correo_electronico", length=60)
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    @Column(name="nacionalidad", length=20)
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_nacimiento", nullable=false, length=19)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }




}


