package corp.data.data.manager;


import corp.data.data.dto.Marca;
import corp.data.data.excepcion.ExcepcionManager;

public interface MarcaManager {
    public String save(Marca m) throws ExcepcionManager;
    public String remove(Marca m) throws ExcepcionManager;
}
