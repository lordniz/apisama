package pe.edu.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.apisama.model.Noticias;

public interface NoticiasRepository extends JpaRepository<Noticias, Integer> {
}
