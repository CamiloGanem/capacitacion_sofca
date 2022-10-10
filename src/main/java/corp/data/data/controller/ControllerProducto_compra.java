package corp.data.data.controller;

import corp.data.data.dto.Producto_compra;
import corp.data.data.excepcion.ExcepcionManager;
import corp.data.data.manager.Producto_compraManager;
import corp.data.data.manager.Producto_compraManagerImplement;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class ControllerProducto_compra {

    Producto_compraManager manager = new Producto_compraManagerImplement();

    @PostMapping("/prod_compra/save")
    public void save(@RequestBody Producto_compra compra){
        try {
            manager.save(compra);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/prod_compra/remove")
    public void remove(@RequestBody Producto_compra compra){
        try {
            manager.remove(compra);
        } catch (ExcepcionManager e) {
            e.printStackTrace();
        }
    }
}
