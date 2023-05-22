package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Departamentos")
public class Departamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Departamento")
    private int idDepartamento;

    @Column(name = "Nombre_Departamento")
    private String nombreDepartamento;
}
