package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Tardanzas;
import pe.edu.cibertec.apisama.repository.TardanzasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TardanzasService {

    private final TardanzasRepository tardanzasRepository;

    @Autowired
    public TardanzasService(TardanzasRepository tardanzasRepository) {
        this.tardanzasRepository = tardanzasRepository;
    }

    public Tardanzas crearTardanza(Tardanzas tardanza) {
        return tardanzasRepository.save(tardanza);
    }

    public List<Tardanzas> listarTardanzas() {
        return tardanzasRepository.findAll();
    }

    public Tardanzas obtenerTardanzaPorId(int id) {
        Optional<Tardanzas> tardanza = tardanzasRepository.findById(id);
        if (tardanza.isPresent()) {
            return tardanza.get();
        } else {
            throw new IllegalArgumentException("No se encontró la tardanza especificada.");
        }
    }

    public Tardanzas actualizarTardanza(Tardanzas tardanza) {
        validarExistenciaTardanza(tardanza.getIdTardanza());
        return tardanzasRepository.save(tardanza);
    }

    public void eliminarTardanza(int id) {
        validarExistenciaTardanza(id);
        tardanzasRepository.deleteById(id);
    }

    private void validarExistenciaTardanza(int id) {
        if (!tardanzasRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró la tardanza especificada.");
        }
    }
}
