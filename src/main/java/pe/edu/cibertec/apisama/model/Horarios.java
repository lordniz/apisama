package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

@Data
@Entity
@Table(name = "Horarios")
public class Horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Horario")
    private int idHorario;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Hora_entrada")
    private String horaEntrada;

    @Column(name = "Hora_salida")
    private String horaSalida;
}
