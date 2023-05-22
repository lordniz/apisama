package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Permisos")
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Permiso")
    private int idPermiso;

    @ManyToOne
    @JoinColumn(name = "ID_Empleado")
    private Empleados empleado;

    @Column(name = "Fecha_inicio")
    private String fechaInicio;

    @Column(name = "Fecha_fin")
    private String fechaFin;

    @Column(name = "Motivo")
    private String motivo;

    @Column(name = "Estado")
    private String estado;
}
