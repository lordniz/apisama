package pe.edu.cibertec.apisama.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import pe.edu.cibertec.apisama.model.Noticias;
        import pe.edu.cibertec.apisama.repository.NoticiasRepository;

        import java.util.List;
        import java.util.Optional;

@Service
public class NoticiasService {

    private final NoticiasRepository noticiasRepository;

    @Autowired
    public NoticiasService(NoticiasRepository noticiasRepository) {
        this.noticiasRepository = noticiasRepository;
    }

    public Noticias crearRol(Noticias noticias) {
        return noticiasRepository.save(noticias);
    }

    public List<Noticias> listarRoles() {
        return noticiasRepository.findAll();
    }

    public Noticias obtenerRolPorId(int id) {
        Optional<Noticias> rol = noticiasRepository.findById(id);
        if (rol.isPresent()) {
            return rol.get();
        } else {
            throw new IllegalArgumentException("No se encontró el rol especificado.");
        }
    }

    public Noticias actualizarRol(Noticias noticias) {
        validarExistenciaNoticia(noticias.getIdNoticia());
        return noticiasRepository.save(noticias);
    }

    public void eliminarRol(int id) {
        validarExistenciaNoticia(id);
        noticiasRepository.deleteById(id);
    }

    private void validarExistenciaNoticia(int id) {
        if (!noticiasRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el rol especificado.");
        }
    }
}
