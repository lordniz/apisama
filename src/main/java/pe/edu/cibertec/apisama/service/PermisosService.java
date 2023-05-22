package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Permisos;
import pe.edu.cibertec.apisama.repository.PermisosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PermisosService {

    private final PermisosRepository permisosRepository;

    @Autowired
    public PermisosService(PermisosRepository permisosRepository) {
        this.permisosRepository = permisosRepository;
    }

    public Permisos crearPermiso(Permisos permiso) {
        return permisosRepository.save(permiso);
    }

    public List<Permisos> listarPermisos() {
        return permisosRepository.findAll();
    }

    public Permisos obtenerPermisoPorId(int id) {
        Optional<Permisos> permiso = permisosRepository.findById(id);
        if (permiso.isPresent()) {
            return permiso.get();
        } else {
            throw new IllegalArgumentException("No se encontró el permiso especificado.");
        }
    }

    public Permisos actualizarPermiso(Permisos permiso) {
        validarExistenciaPermiso(permiso.getIdPermiso());
        return permisosRepository.save(permiso);
    }

    public void eliminarPermiso(int id) {
        validarExistenciaPermiso(id);
        permisosRepository.deleteById(id);
    }

    private void validarExistenciaPermiso(int id) {
        if (!permisosRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el permiso especificado.");
        }
    }
}
