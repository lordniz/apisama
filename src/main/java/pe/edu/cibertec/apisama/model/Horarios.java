package pe.edu.cibertec.apisama.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(name = "hora_entrada")
    private String horaEntrada;

    @Column(name = "hora_salida")
    private String horaSalida;
}
