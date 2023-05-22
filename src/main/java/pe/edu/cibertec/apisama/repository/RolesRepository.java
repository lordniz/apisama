package pe.edu.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.apisama.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
