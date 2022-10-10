package corp.data.data.manager;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dao.MarcaDao;
import corp.data.data.dao.MarcaDaoImplement;
import corp.data.data.dto.Marca;
import corp.data.data.excepcion.ExcepcionDao;
import corp.data.data.excepcion.ExcepcionManager;

public class MarcaManagerImplement implements MarcaManager {

    MarcaDao dao = new MarcaDaoImplement();
    ManagerConexion mg = ManagerConexion.getInstance();
    @Override
    public String save(Marca m) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Marca m_find = dao.getByName(m.getNombre_marca());
            if(m_find == null){
                dao.insert(m);
                mensaje = "La marca se a registrado correctamente";
            }else {
                dao.update(m);
                mensaje = "La marca se a actualizado correctamente";
            }
            mg.commit();
        } catch (ExcepcionDao e) {
            mg.rolback();
            throw new ExcepcionManager(e);
        }catch (Exception e){
            mg.rolback();
            throw new ExcepcionManager(e);
        }finally {
            mg.close();
        }
        return mensaje;
    }

    @Override
    public String remove(Marca m) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Marca m_find = dao.getById(m.getCodigo_marca());
            if(m_find != null){
                dao.delete(m);
                mensaje = "La marca se a eliminado correctamente";
                mg.commit();
            }else {
                mensaje = "No hay marca con ese codigo";
            }

        } catch (ExcepcionDao e) {
            mg.rolback();
            throw new ExcepcionManager(e);
        }catch (Exception e){
            mg.rolback();
            throw new ExcepcionManager(e);
        }finally {
            mg.close();
        }
        return mensaje;
    }
}
