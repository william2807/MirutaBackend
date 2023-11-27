
package com.example.demo.controlador;

import com.example.demo.dao.RutasDao;
import com.example.demo.modelo.Rutas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Rutas")
public class RutasController {
    
    @Autowired
    RutasDao rutasDao;
    
    //traer todas las rutas
    @GetMapping(value = "/Todos")
    //se crea un funcion que tenga una lista de Rutas
    List<Rutas>getAll(){
       return rutasDao.getAll();       
    }
    
    @GetMapping(value = "/{id}")
    //Se usa el pathVariable para que el {id} = id, sea identificado         
    Rutas get(@PathVariable long id){
       return rutasDao.get(id);
    }
    
    @PostMapping(value = "/Registrar")
    public String registrar(@RequestBody Rutas ruta){
        rutasDao.registrar(ruta);
        return "Registrado con exito";
        
    } 
    @DeleteMapping(value = "/{id}")
    public String eliminar(@PathVariable long id){
        rutasDao.eliminar(id);
        return "eliminado Correctamente";
    }
    
}

