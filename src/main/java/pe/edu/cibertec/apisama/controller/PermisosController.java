package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.Permisos;
import pe.edu.cibertec.apisama.service.PermisosService;

import java.util.List;

@RestController
@RequestMapping("/permisos")
public class PermisosController {

    private final PermisosService permisosService;

    @Autowired
    public PermisosController(PermisosService permisosService) {
        this.permisosService = permisosService;
    }

    @PostMapping
    public ResponseEntity<Permisos> crearPermiso(@RequestBody Permisos permiso) {
        Permisos nuevoPermiso = permisosService.crearPermiso(permiso);
        return new ResponseEntity<>(nuevoPermiso, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Permisos>> listarPermisos() {
        List<Permisos> permisos = permisosService.listarPermisos();
        return new ResponseEntity<>(permisos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permisos> obtenerPermisoPorId(@PathVariable int id) {
        Permisos permiso = permisosService.obtenerPermisoPorId(id);
        return new ResponseEntity<>(permiso, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permisos> actualizarPermiso(@PathVariable int id, @RequestBody Permisos permiso) {
        permiso.setIdPermiso(id);
        Permisos permisoActualizado = permisosService.actualizarPermiso(permiso);
        return new ResponseEntity<>(permisoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable int id) {
        permisosService.eliminarPermiso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
