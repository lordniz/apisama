package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Empleado")
    private int idEmpleado;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "ID_Horario")
    private Horarios horario;

    @ManyToOne
    @JoinColumn(name = "ID_Departamento")
    private Departamentos departamento;

}
