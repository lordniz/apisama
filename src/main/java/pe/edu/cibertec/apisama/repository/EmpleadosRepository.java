package pe.edu.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.apisama.model.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {
}
