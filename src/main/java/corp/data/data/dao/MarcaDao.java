package corp.data.data.dao;


import corp.data.data.dto.Marca;
import corp.data.data.excepcion.ExcepcionDao;

public interface MarcaDao {
    public void insert(Marca m) throws ExcepcionDao;
    public void update(Marca m) throws ExcepcionDao;
    public void delete(Marca m) throws ExcepcionDao;
    public Marca getByName(String nombre) throws ExcepcionDao;
    public Marca getById(int codigo) throws ExcepcionDao;

}
