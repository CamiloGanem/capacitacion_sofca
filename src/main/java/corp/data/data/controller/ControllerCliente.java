package corp.data.data.controller;


import corp.data.data.dto.Cliente;
import corp.data.data.dto.Respuesta;
import corp.data.data.excepcion.ExcepcionManager;
import corp.data.data.manager.ClienteManager;
import corp.data.data.manager.ClienteManagerImplement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/demo")
public class ControllerCliente {

    ClienteManager manager = new ClienteManagerImplement();

    @PostMapping(path = "/cliente/save")
    public @ResponseBody void save (@RequestBody Cliente cliente){

        try {
            manager.save(cliente);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }

    }

    @DeleteMapping(path = "/cliente/remove")
    public void romove(@RequestBody Cliente cliente){
        try {
            manager.remove(cliente);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/cliente/lista")
    public Respuesta lista(){
        Respuesta respuesta = new Respuesta();
        try {
            List lista = manager.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (ExcepcionManager e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }

}
