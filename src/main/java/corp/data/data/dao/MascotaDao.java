package corp.data.data.dao;


import corp.data.data.dto.Mascota;
import corp.data.data.excepcion.ExcepcionDao;

public interface MascotaDao {
    public void insert(Mascota m) throws ExcepcionDao;
    public void update(Mascota m) throws ExcepcionDao;
    public void delete(Mascota m) throws ExcepcionDao;
    public Mascota getById(int codigo) throws ExcepcionDao;
}
