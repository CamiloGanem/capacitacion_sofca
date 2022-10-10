package corp.data.data.dao;


import corp.data.data.dto.Producto;
import corp.data.data.excepcion.ExcepcionDao;

public interface ProductoDao {
    public void insert(Producto p) throws ExcepcionDao;
    public void update(Producto p) throws ExcepcionDao;
    public void delete(Producto p) throws ExcepcionDao;
    public Producto getById(int codigo) throws ExcepcionDao;
}
