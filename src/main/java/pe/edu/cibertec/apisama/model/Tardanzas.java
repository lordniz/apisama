package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Tardanzas")
public class Tardanzas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Tardanza")
    private int idTardanza;

    @ManyToOne
    @JoinColumn(name = "ID_Empleado")
    private Empleados empleado;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "Hora_tardanza")
    private String horaTardanza;
}
