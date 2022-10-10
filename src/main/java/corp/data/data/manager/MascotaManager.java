package corp.data.data.manager;


import corp.data.data.dto.Mascota;
import corp.data.data.excepcion.ExcepcionManager;

public interface MascotaManager {
    public String save(Mascota m) throws ExcepcionManager;
    public String remove(Mascota m) throws ExcepcionManager;
}
