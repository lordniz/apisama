package pe.edu.cibertec.apisama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.apisama.model.Empleados;
import pe.edu.cibertec.apisama.service.EmpleadosService;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    private final EmpleadosService empleadosService;

    @Autowired
    public EmpleadosController(EmpleadosService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @PostMapping
    public ResponseEntity<Empleados> crearEmpleado(@RequestBody Empleados empleado) {
        Empleados nuevoEmpleado = empleadosService.crearEmpleado(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Empleados>> listarEmpleados() {
        List<Empleados> empleados = empleadosService.listarEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleados> obtenerEmpleadoPorId(@PathVariable int id) {
        Empleados empleado = empleadosService.obtenerEmpleadoPorId(id);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleados> actualizarEmpleado(@PathVariable int id, @RequestBody Empleados empleado) {
        empleado.setIdEmpleado(id);
        Empleados empleadoActualizado = empleadosService.actualizarEmpleado(empleado);
        return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable int id) {
        empleadosService.eliminarEmpleado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
