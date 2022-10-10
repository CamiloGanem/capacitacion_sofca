package corp.data.data.controller;

import corp.data.data.dto.Compra;
import corp.data.data.excepcion.ExcepcionManager;
import corp.data.data.manager.CompraManager;
import corp.data.data.manager.CompraManagerImplement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class ControllerCompra {

    CompraManager manager = new CompraManagerImplement();

    @PostMapping(path = "/compra/save")
    public void save(@RequestBody Compra compra){
        try {
            manager.save(compra);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/compra/remove")
    public void remove(@RequestBody Compra compra){
        try {
            manager.remove(compra);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }
}
