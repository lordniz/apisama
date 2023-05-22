package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.Roles;
import pe.edu.cibertec.apisama.service.RolesService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping
    public ResponseEntity<Roles> crearRol(@RequestBody Roles rol) {
        Roles nuevoRol = rolesService.crearRol(rol);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Roles>> listarRoles() {
        List<Roles> roles = rolesService.listarRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> obtenerRolPorId(@PathVariable int id) {
        Roles rol = rolesService.obtenerRolPorId(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> actualizarRol(@PathVariable int id, @RequestBody Roles rol) {
        rol.setIdRol(id);
        Roles rolActualizado = rolesService.actualizarRol(rol);
        return new ResponseEntity<>(rolActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable int id) {
        rolesService.eliminarRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
