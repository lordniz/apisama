package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Faltas")
public class Faltas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Falta")
    private int idFalta;

    @ManyToOne
    @JoinColumn(name = "ID_Empleado")
    private Empleados empleado;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "Motivo")
    private String motivo;
}
