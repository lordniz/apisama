package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.Tardanzas;
import pe.edu.cibertec.apisama.service.TardanzasService;

import java.util.List;

@RestController
@RequestMapping("/tardanzas")
public class TardanzasController {

    private final TardanzasService tardanzasService;

    @Autowired
    public TardanzasController(TardanzasService tardanzasService) {
        this.tardanzasService = tardanzasService;
    }

    @PostMapping
    public ResponseEntity<Tardanzas> crearTardanza(@RequestBody Tardanzas tardanza) {
        Tardanzas nuevaTardanza = tardanzasService.crearTardanza(tardanza);
        return new ResponseEntity<>(nuevaTardanza, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tardanzas>> listarTardanzas() {
        List<Tardanzas> tardanzas = tardanzasService.listarTardanzas();
        return new ResponseEntity<>(tardanzas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tardanzas> obtenerTardanzaPorId(@PathVariable int id) {
        Tardanzas tardanza = tardanzasService.obtenerTardanzaPorId(id);
        return new ResponseEntity<>(tardanza, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tardanzas> actualizarTardanza(@PathVariable int id, @RequestBody Tardanzas tardanza) {
        tardanza.setIdTardanza(id);
        Tardanzas tardanzaActualizada = tardanzasService.actualizarTardanza(tardanza);
        return new ResponseEntity<>(tardanzaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTardanza(@PathVariable int id) {
        tardanzasService.eliminarTardanza(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
