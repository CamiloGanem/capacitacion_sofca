package corp.data.data.manager;


import corp.data.data.dto.Producto;
import corp.data.data.excepcion.ExcepcionManager;

public interface ProductoManager {
    public String save(Producto p) throws ExcepcionManager;
    public String remove(Producto p) throws ExcepcionManager;
}
