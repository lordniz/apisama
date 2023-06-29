package pe.edu.cibertec.apisama.model;

import lombok.Data;

@Data
public class UsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String direccion;
    private String celular;
    private Roles rol;
}
