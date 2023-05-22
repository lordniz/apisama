package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Asistencias;
import pe.edu.cibertec.apisama.repository.AsistenciasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciasService {

    private final AsistenciasRepository asistenciasRepository;

    @Autowired
    public AsistenciasService(AsistenciasRepository asistenciasRepository) {
        this.asistenciasRepository = asistenciasRepository;
    }

    public Asistencias crearAsistencia(Asistencias asistencia) {
        return asistenciasRepository.save(asistencia);
    }

    public List<Asistencias> listarAsistencias() {
        return asistenciasRepository.findAll();
    }

    public Asistencias obtenerAsistenciaPorId(int id) {
        Optional<Asistencias> asistencia = asistenciasRepository.findById(id);
        if (asistencia.isPresent()) {
            return asistencia.get();
        } else {
            throw new IllegalArgumentException("No se encontró la asistencia especificada.");
        }
    }

    public Asistencias actualizarAsistencia(Asistencias asistencia) {
        Optional<Asistencias> asistenciaExistente = asistenciasRepository.findById(asistencia.getIdAsistencia());
        if (asistenciaExistente.isPresent()) {
            return asistenciasRepository.save(asistencia);
        } else {
            throw new IllegalArgumentException("No se encontró la asistencia especificada.");
        }
    }

    public void eliminarAsistencia(int id) {
        Optional<Asistencias> asistenciaExistente = asistenciasRepository.findById(id);
        if (asistenciaExistente.isPresent()) {
            asistenciasRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró la asistencia especificada.");
        }
    }
}
