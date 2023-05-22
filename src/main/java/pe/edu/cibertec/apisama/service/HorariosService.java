package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Horarios;
import pe.edu.cibertec.apisama.repository.HorariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HorariosService {

    private final HorariosRepository horariosRepository;

    @Autowired
    public HorariosService(HorariosRepository horariosRepository) {
        this.horariosRepository = horariosRepository;
    }

    public Horarios crearHorario(Horarios horario) {
        return horariosRepository.save(horario);
    }

    public List<Horarios> listarHorarios() {
        return horariosRepository.findAll();
    }

    public Horarios obtenerHorarioPorId(int id) {
        Optional<Horarios> horario = horariosRepository.findById(id);
        if (horario.isPresent()) {
            return horario.get();
        } else {
            // Manejar el caso de horario no encontrado
            throw new IllegalArgumentException("No se encontró el horario especificado.");
        }
    }

    public Horarios actualizarHorario(Horarios horario) {
        Optional<Horarios> horarioExistente = horariosRepository.findById(horario.getIdHorario());
        if (horarioExistente.isPresent()) {
            return horariosRepository.save(horario);
        } else {
            // Manejar el caso de horario no encontrado
            throw new IllegalArgumentException("No se encontró el horario especificado.");
        }
    }

    public void eliminarHorario(int id) {
        Optional<Horarios> horarioExistente = horariosRepository.findById(id);
        if (horarioExistente.isPresent()) {
            horariosRepository.deleteById(id);
        } else {
            // Manejar el caso de horario no encontrado
            throw new IllegalArgumentException("No se encontró el horario especificado.");
        }
    }
}
