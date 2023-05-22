package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Faltas;
import pe.edu.cibertec.apisama.repository.FaltasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FaltasService {

    private final FaltasRepository faltasRepository;

    @Autowired
    public FaltasService(FaltasRepository faltasRepository) {
        this.faltasRepository = faltasRepository;
    }

    public Faltas crearFalta(Faltas falta) {
        return faltasRepository.save(falta);
    }

    public List<Faltas> listarFaltas() {
        return faltasRepository.findAll();
    }

    public Faltas obtenerFaltaPorId(int id) {
        Optional<Faltas> falta = faltasRepository.findById(id);
        if (falta.isPresent()) {
            return falta.get();
        } else {
            throw new IllegalArgumentException("No se encontró la falta especificada.");
        }
    }

    public Faltas actualizarFalta(Faltas falta) {
        validarExistenciaFalta(falta.getIdFalta());
        return faltasRepository.save(falta);
    }

    public void eliminarFalta(int id) {
        validarExistenciaFalta(id);
        faltasRepository.deleteById(id);
    }

    private void validarExistenciaFalta(int id) {
        if (!faltasRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró la falta especificada.");
        }
    }
}
