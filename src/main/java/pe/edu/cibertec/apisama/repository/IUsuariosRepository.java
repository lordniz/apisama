package pe.edu.cibertec.apisama.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.apisama.model.Usuarios;

import java.util.Optional;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Long> {
    //Método para poder buscar un usuario mediante su email
    Optional<Usuarios> findByCorreo(String correo);

    //Método para poder verificar si un usuario existe en nuestra base de datos
    Boolean existsByCorreo(String correo);
}
