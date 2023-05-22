package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.Departamentos;
import pe.edu.cibertec.apisama.service.DepartamentosService;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentosController {

    private final DepartamentosService departamentosService;

    @Autowired
    public DepartamentosController(DepartamentosService departamentosService) {
        this.departamentosService = departamentosService;
    }

    @PostMapping
    public ResponseEntity<Departamentos> crearDepartamento(@RequestBody Departamentos departamento) {
        Departamentos nuevoDepartamento = departamentosService.crearDepartamento(departamento);
        return new ResponseEntity<>(nuevoDepartamento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Departamentos>> listarDepartamentos() {
        List<Departamentos> departamentos = departamentosService.listarDepartamentos();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamentos> obtenerDepartamentoPorId(@PathVariable int id) {
        Departamentos departamento = departamentosService.obtenerDepartamentoPorId(id);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamentos> actualizarDepartamento(@PathVariable int id, @RequestBody Departamentos departamento) {
        departamento.setIdDepartamento(id);
        Departamentos departamentoActualizado = departamentosService.actualizarDepartamento(departamento);
        return new ResponseEntity<>(departamentoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable int id) {
        departamentosService.eliminarDepartamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
