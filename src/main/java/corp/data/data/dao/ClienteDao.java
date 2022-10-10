package corp.data.data.dao;


import corp.data.data.dto.Cliente;
import corp.data.data.excepcion.ExcepcionDao;

public interface ClienteDao {
    public void insert(Cliente c) throws ExcepcionDao;
    public void update(Cliente c) throws ExcepcionDao;
    public void delete(Cliente c) throws ExcepcionDao;
    public Cliente getById(int iden) throws ExcepcionDao;
}
