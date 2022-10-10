package corp.data.data.controller;

import corp.data.data.dto.Producto;
import corp.data.data.excepcion.ExcepcionManager;
import corp.data.data.manager.ProductoManager;
import corp.data.data.manager.ProductoManagerImplement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class ControllerProducto {

    ProductoManager manager = new ProductoManagerImplement();

    @PostMapping("/producto/save")
    public void save(@RequestBody Producto producto){
        try {
            manager.save(producto);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/producto/remove")
    public void remove(@RequestBody Producto producto){
        try {
            manager.remove(producto);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

}
