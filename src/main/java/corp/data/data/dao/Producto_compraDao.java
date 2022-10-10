package corp.data.data.dao;


import corp.data.data.dto.Producto_compra;
import corp.data.data.excepcion.ExcepcionDao;

public interface Producto_compraDao {
    public void insert(Producto_compra pc) throws ExcepcionDao;
    public void update(Producto_compra pc) throws ExcepcionDao;
    public void delete(Producto_compra pc) throws ExcepcionDao;
    public Producto_compra getById(int codigo) throws ExcepcionDao;
}
