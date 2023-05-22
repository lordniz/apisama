package pe.edu.cibertec.apisama.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Empleados;
import pe.edu.cibertec.apisama.repository.EmpleadosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    @Autowired
    public EmpleadosService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    public Empleados crearEmpleado(Empleados empleado) {
        return empleadosRepository.save(empleado);
    }

    public List<Empleados> listarEmpleados() {
        return empleadosRepository.findAll();
    }

    public Empleados obtenerEmpleadoPorId(int id) {
        Optional<Empleados> empleado = empleadosRepository.findById(id);
        if (empleado.isPresent()) {
            return empleado.get();
        } else {
            throw new IllegalArgumentException("No se encontró el empleado especificado.");
        }
    }

    public Empleados actualizarEmpleado(Empleados empleado) {
        validarExistenciaEmpleado(empleado.getIdEmpleado());
        return empleadosRepository.save(empleado);
    }

    public void eliminarEmpleado(int id) {
        validarExistenciaEmpleado(id);
        empleadosRepository.deleteById(id);
    }

    private void validarExistenciaEmpleado(int id) {
        if (!empleadosRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el empleado especificado.");
        }
    }
}
