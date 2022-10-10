package corp.data.data.dao;

import corp.data.data.dto.Compra;
import corp.data.data.excepcion.ExcepcionDao;

public interface CompraDao {
    public void insert(Compra c) throws ExcepcionDao;
    public void update(Compra c) throws ExcepcionDao;
    public void delete(Compra c) throws ExcepcionDao;
    public Compra getById(int codigo) throws ExcepcionDao;
}
