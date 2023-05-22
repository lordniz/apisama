package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Asistencias")
public class Asistencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Asistencia")
    private int idAsistencia;

    @ManyToOne
    @JoinColumn(name = "ID_Empleado")
    private Empleados empleado;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "Hora_entrada")
    private String horaEntrada;

    @Column(name = "Hora_salida")
    private String horaSalida;
}
