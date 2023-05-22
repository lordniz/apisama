package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Roles;
import pe.edu.cibertec.apisama.repository.RolesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Roles crearRol(Roles rol) {
        return rolesRepository.save(rol);
    }

    public List<Roles> listarRoles() {
        return rolesRepository.findAll();
    }

    public Roles obtenerRolPorId(int id) {
        Optional<Roles> rol = rolesRepository.findById(id);
        if (rol.isPresent()) {
            return rol.get();
        } else {
            throw new IllegalArgumentException("No se encontró el rol especificado.");
        }
    }

    public Roles actualizarRol(Roles rol) {
        validarExistenciaRol(rol.getIdRol());
        return rolesRepository.save(rol);
    }

    public void eliminarRol(int id) {
        validarExistenciaRol(id);
        rolesRepository.deleteById(id);
    }

    private void validarExistenciaRol(int id) {
        if (!rolesRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el rol especificado.");
        }
    }
}
