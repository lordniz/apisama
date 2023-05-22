package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.Horarios;
import pe.edu.cibertec.apisama.service.HorariosService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorariosController {

    private final HorariosService horariosService;

    @Autowired
    public HorariosController(HorariosService horariosService) {
        this.horariosService = horariosService;
    }

    @PostMapping
    public ResponseEntity<Horarios> crearHorario(@RequestBody Horarios horario) {
        Horarios nuevoHorario = horariosService.crearHorario(horario);
        return new ResponseEntity<>(nuevoHorario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Horarios>> listarHorarios() {
        List<Horarios> horarios = horariosService.listarHorarios();
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horarios> obtenerHorarioPorId(@PathVariable int id) {
        Horarios horario = horariosService.obtenerHorarioPorId(id);
        return new ResponseEntity<>(horario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horarios> actualizarHorario(@PathVariable int id, @RequestBody Horarios horario) {
        horario.setIdHorario(id);
        Horarios horarioActualizado = horariosService.actualizarHorario(horario);
        return new ResponseEntity<>(horarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable int id) {
        horariosService.eliminarHorario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
