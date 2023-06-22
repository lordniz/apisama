package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apisama.model.Noticias;
import pe.edu.cibertec.apisama.service.NoticiasService;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {
    private final NoticiasService noticiasService;
    @Autowired
    public NoticiasController(NoticiasService noticiasService) {
        this.noticiasService = noticiasService;
    }

    @PostMapping
    public ResponseEntity<Noticias> crearRol(@RequestBody Noticias noticias) {
        Noticias nuevoRol = noticiasService.crearNoticia(noticias);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Noticias>> listarRoles() {
        List<Noticias> noticias = noticiasService.listarNoticia();
        return new ResponseEntity<>(noticias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticias> obtenerRolPorId(@PathVariable int id) {
        Noticias noticias = noticiasService.obtenerNoticiaPorId(id);
        return new ResponseEntity<>(noticias, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticias> actualizarRol(@PathVariable int id, @RequestBody Noticias noticias) {
        noticias.setIdNoticia(id);
        Noticias noticiaActualizado = noticiasService.actualizarNoticia(noticias);
        return new ResponseEntity<>(noticiaActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable int id) {
        noticiasService.eliminarNoticia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
