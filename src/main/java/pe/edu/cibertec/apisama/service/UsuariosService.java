package pe.edu.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.apisama.model.Usuarios;
import pe.edu.cibertec.apisama.repository.UsuariosRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Usuarios crearUsuario(Usuarios usuario) {
        String contraseñaEncriptada = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(contraseñaEncriptada);
        return usuariosRepository.save(usuario);
    }


    public List<Usuarios> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios obtenerUsuarioPorId(int id) {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new IllegalArgumentException("No se encontró el usuario especificado.");
        }
    }

    public Usuarios modificarUsuario(int id, Usuarios usuarioModificado) {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            String contraseñaModificadaEncriptada = passwordEncoder.encode(usuarioModificado.getContraseña());
            Usuarios usuarioExistente = usuarioOptional.get();
            // Actualizar los campos necesarios del usuario existente con los valores del usuario modificado
            usuarioExistente.setNombre(usuarioModificado.getNombre());
            usuarioExistente.setApellido(usuarioModificado.getApellido());
            usuarioExistente.setDni(usuarioModificado.getDni());
            usuarioExistente.setCorreo(usuarioModificado.getCorreo());
            usuarioExistente.setContraseña(contraseñaModificadaEncriptada);
            usuarioExistente.setRol(usuarioModificado.getRol());
            return usuariosRepository.save(usuarioExistente);
        } else {
            throw new IllegalArgumentException("No se encontró el usuario especificado.");
        }
    }

    public void eliminarUsuario(int id) {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuariosRepository.delete(usuarioOptional.get());
        } else {
            throw new IllegalArgumentException("No se encontró el usuario especificado.");
        }
    }
}
