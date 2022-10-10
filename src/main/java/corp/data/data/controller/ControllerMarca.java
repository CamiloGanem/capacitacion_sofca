package corp.data.data.controller;

import corp.data.data.dto.Marca;
import corp.data.data.excepcion.ExcepcionManager;
import corp.data.data.manager.MarcaManager;
import corp.data.data.manager.MarcaManagerImplement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class ControllerMarca {

    MarcaManager manager = new MarcaManagerImplement();

    @PostMapping("marca/save")
    public void save(@RequestBody Marca marca){
        try {
            manager.save(marca);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("marca/remove")
    public void remove(@RequestBody Marca marca){
        try {
            manager.remove(marca);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

}
