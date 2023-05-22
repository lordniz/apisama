package pe.edu.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.apisama.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
}
