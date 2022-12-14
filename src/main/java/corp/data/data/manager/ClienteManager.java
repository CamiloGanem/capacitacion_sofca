package corp.data.data.manager;


import corp.data.data.dto.Cliente;
import corp.data.data.excepcion.ExcepcionManager;

import java.util.List;

public interface ClienteManager {
    public String save(Cliente c) throws ExcepcionManager;
    public String remove(Cliente c) throws ExcepcionManager;
    public List<Cliente> listado() throws ExcepcionManager;
}
