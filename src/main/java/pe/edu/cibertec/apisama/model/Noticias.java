package pe.edu.cibertec.apisama.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Noticias")
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Noticias")
    private int idNoticia;

    @Column(name = "Noticia_titulo")
    private String titulo;

    @Column(name = "Noticia_detalle")
    private String detalle;

    @Column(name = "Estado")
    private String estado;
}
