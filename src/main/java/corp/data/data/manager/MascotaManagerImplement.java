package corp.data.data.manager;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dao.MascotaDao;
import corp.data.data.dao.MascotaDaoImplement;
import corp.data.data.dto.Mascota;
import corp.data.data.excepcion.ExcepcionDao;
import corp.data.data.excepcion.ExcepcionManager;

public class MascotaManagerImplement implements MascotaManager{

    MascotaDao dao = new MascotaDaoImplement();
    ManagerConexion mg = ManagerConexion.getInstance();

    @Override
    public String save(Mascota m) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Mascota m_find = dao.getById(m.getCodigo_masco());
            if(m_find == null){
                dao.insert(m);
                mensaje = "La mascota se a registrado correctamente";
            }else {
                dao.update(m);
                mensaje = "La mascota se a actualizado correctamente";
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
    public String remove(Mascota m) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Mascota m_find = dao.getById(m.getCodigo_masco());
            if(m_find != null){
                dao.delete(m);
                mensaje = "La mascota se a eliminado correctamente";
                mg.commit();
            }else {
                mensaje = "No hay mascota con ese codigo";
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
