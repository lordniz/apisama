package pe.edu.cibertec.apisama.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private int idUsuario;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Dni")
    private String dni;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Contraseña")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "ID_Rol")
    private Roles rol;

    // Constructor, getters, and setters
}
