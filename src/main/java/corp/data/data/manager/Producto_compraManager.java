package corp.data.data.manager;


import corp.data.data.dto.Producto_compra;
import corp.data.data.excepcion.ExcepcionManager;

public interface Producto_compraManager {
    public void save(Producto_compra pc) throws ExcepcionManager;
    public void remove(Producto_compra pc) throws ExcepcionManager;
}
