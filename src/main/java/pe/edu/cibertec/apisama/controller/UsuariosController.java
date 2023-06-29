package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.UsuarioDTO;
import pe.edu.cibertec.apisama.model.Usuarios;
import pe.edu.cibertec.apisama.service.UsuariosService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping
    public ResponseEntity<Integer> crearUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = usuariosService.crearUsuario(usuario);
        Usuarios usuarioSinContraseña = new Usuarios();
        BeanUtils.copyProperties(nuevoUsuario, usuarioSinContraseña);
        usuarioSinContraseña.setContraseña(null);
        return new ResponseEntity<>(usuarioSinContraseña.getIdUsuario(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<Usuarios> usuarios = usuariosService.listarUsuarios();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuarios usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(usuario, usuarioDTO);
            usuariosDTO.add(usuarioDTO);
        }

        return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable int id) {
        Usuarios usuario = usuariosService.obtenerUsuarioPorId(id);
        Usuarios usuarioSinContraseña = new Usuarios();
        BeanUtils.copyProperties(usuario, usuarioSinContraseña);
        usuarioSinContraseña.setContraseña(null);
        return new ResponseEntity<>(usuarioSinContraseña, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> modificarUsuario(@PathVariable int id, @RequestBody Usuarios usuarioModificado) {
        Usuarios usuarioActualizado = usuariosService.modificarUsuario(id, usuarioModificado);
        Usuarios usuarioActualizadoSinContraseña = new Usuarios();
        BeanUtils.copyProperties(usuarioActualizado, usuarioActualizadoSinContraseña);
        usuarioActualizadoSinContraseña.setContraseña(null);
        return new ResponseEntity<>(usuarioActualizadoSinContraseña.getIdUsuario(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuariosService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
