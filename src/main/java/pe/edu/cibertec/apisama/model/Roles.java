package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Roles")
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Rol")
    private int idRol;

    @Column(name = "Nombre_Rol")
    private String nombreRol;

    // Constructor, getters, and setters
}
