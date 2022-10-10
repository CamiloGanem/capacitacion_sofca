package corp.data.data.controller;

import corp.data.data.dto.Mascota;
import corp.data.data.excepcion.ExcepcionManager;
import corp.data.data.manager.MascotaManager;
import corp.data.data.manager.MascotaManagerImplement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class ControllerMascota {

    MascotaManager manager = new MascotaManagerImplement();

    @PostMapping("/mascota/save")
    public void save(@RequestBody Mascota mascota){
        try {
            manager.save(mascota);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/mascota/remove")
    public void remove(@RequestBody Mascota mascota){
        try {
            manager.remove(mascota);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }
}
