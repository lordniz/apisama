package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Departamentos;
import pe.edu.cibertec.apisama.repository.DepartamentosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentosService {

    private final DepartamentosRepository departamentosRepository;

    @Autowired
    public DepartamentosService(DepartamentosRepository departamentosRepository) {
        this.departamentosRepository = departamentosRepository;
    }

    public Departamentos crearDepartamento(Departamentos departamento) {
        return departamentosRepository.save(departamento);
    }

    public List<Departamentos> listarDepartamentos() {
        return departamentosRepository.findAll();
    }

    public Departamentos obtenerDepartamentoPorId(int id) {
        Optional<Departamentos> departamento = departamentosRepository.findById(id);
        if (departamento.isPresent()) {
            return departamento.get();
        } else {
            throw new IllegalArgumentException("No se encontró el departamento especificado.");
        }
    }

    public Departamentos actualizarDepartamento(Departamentos departamento) {
        Optional<Departamentos> departamentoExistente = departamentosRepository.findById(departamento.getIdDepartamento());
        if (departamentoExistente.isPresent()) {
            return departamentosRepository.save(departamento);
        } else {
            throw new IllegalArgumentException("No se encontró el departamento especificado.");
        }
    }

    public void eliminarDepartamento(int id) {
        Optional<Departamentos> departamentoExistente = departamentosRepository.findById(id);
        if (departamentoExistente.isPresent()) {
            departamentosRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró el departamento especificado.");
        }
    }
}
