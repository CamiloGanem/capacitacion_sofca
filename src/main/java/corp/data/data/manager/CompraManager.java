package corp.data.data.manager;


import corp.data.data.dto.Compra;
import corp.data.data.excepcion.ExcepcionManager;

public interface CompraManager {
    public String save(Compra c) throws ExcepcionManager;
    public String remove(Compra c) throws ExcepcionManager;
}
