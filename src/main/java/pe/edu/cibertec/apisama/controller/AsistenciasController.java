package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apisama.model.Asistencias;
import pe.edu.cibertec.apisama.service.AsistenciasService;

import java.util.List;

@RestController
@RequestMapping("/asistencias")
public class AsistenciasController {

    private final AsistenciasService asistenciasService;

    @Autowired
    public AsistenciasController(AsistenciasService asistenciasService) {
        this.asistenciasService = asistenciasService;
    }

    @PostMapping
    public ResponseEntity<Asistencias> crearAsistencia(@RequestBody Asistencias asistencia) {
        Asistencias nuevaAsistencia = asistenciasService.crearAsistencia(asistencia);
        return new ResponseEntity<>(nuevaAsistencia, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Asistencias>> listarAsistencias() {
        List<Asistencias> asistencias = asistenciasService.listarAsistencias();
        return new ResponseEntity<>(asistencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencias> obtenerAsistenciaPorId(@PathVariable int id) {
        Asistencias asistencia = asistenciasService.obtenerAsistenciaPorId(id);
        return new ResponseEntity<>(asistencia, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencias> actualizarAsistencia(@PathVariable int id, @RequestBody Asistencias asistencia) {
        Asistencias asistenciaExistente = asistenciasService.obtenerAsistenciaPorId(id);
        asistenciaExistente.setEmpleado(asistencia.getEmpleado());
        asistenciaExistente.setFecha(asistencia.getFecha());
        asistenciaExistente.setHoraEntrada(asistencia.getHoraEntrada());
        asistenciaExistente.setHoraSalida(asistencia.getHoraSalida());

        Asistencias asistenciaActualizada = asistenciasService.actualizarAsistencia(asistenciaExistente);
        return new ResponseEntity<>(asistenciaActualizada, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsistencia(@PathVariable int id) {
        asistenciasService.eliminarAsistencia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
