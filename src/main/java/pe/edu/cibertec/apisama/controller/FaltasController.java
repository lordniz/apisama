package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.Faltas;
import pe.edu.cibertec.apisama.service.FaltasService;

import java.util.List;

@RestController
@RequestMapping("/faltas")
public class FaltasController {

    private final FaltasService faltasService;

    @Autowired
    public FaltasController(FaltasService faltasService) {
        this.faltasService = faltasService;
    }

    @PostMapping
    public ResponseEntity<Faltas> crearFalta(@RequestBody Faltas falta) {
        Faltas nuevaFalta = faltasService.crearFalta(falta);
        return new ResponseEntity<>(nuevaFalta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Faltas>> listarFaltas() {
        List<Faltas> faltas = faltasService.listarFaltas();
        return new ResponseEntity<>(faltas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faltas> obtenerFaltaPorId(@PathVariable int id) {
        Faltas falta = faltasService.obtenerFaltaPorId(id);
        return new ResponseEntity<>(falta, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faltas> actualizarFalta(@PathVariable int id, @RequestBody Faltas falta) {
        falta.setIdFalta(id);
        Faltas faltaActualizada = faltasService.actualizarFalta(falta);
        return new ResponseEntity<>(faltaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFalta(@PathVariable int id) {
        faltasService.eliminarFalta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
