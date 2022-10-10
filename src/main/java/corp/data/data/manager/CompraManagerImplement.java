package corp.data.data.manager;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dao.CompraDao;
import corp.data.data.dao.CompraDaoImplement;
import corp.data.data.dto.Compra;
import corp.data.data.excepcion.ExcepcionDao;
import corp.data.data.excepcion.ExcepcionManager;

public class CompraManagerImplement implements CompraManager {

    CompraDao dao = new CompraDaoImplement();
    ManagerConexion mg = ManagerConexion.getInstance();
    @Override
    public String save(Compra c) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Compra c_find = dao.getById(c.getCodigo_compra());
            if(c_find == null){
                dao.insert(c);
                mensaje = "La compra se a registrado correctamente";
            }else {
                dao.update(c);
                mensaje = "La compra se a actualizado correctamente";
            }
            mg.commit();
        } catch (ExcepcionDao e) {
            mg.rolback();
            throw new ExcepcionManager(e);
        }catch (Exception e){
            mg.rolback();
            throw new ExcepcionManager(e);
        }finally {
            mg.commit();
        }
        return mensaje;
    }

    @Override
    public String remove(Compra c) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Compra c_find = dao.getById(c.getCodigo_compra());
            if(c_find != null){
                dao.delete(c);
                mensaje = "La compra se a eliminado correctamente";
                mg.commit();
            }else {
                mensaje = "No hay compra con ese codigo";
            }

        } catch (ExcepcionDao e) {
            mg.rolback();
            throw new ExcepcionManager(e);
        }catch (Exception e){
            mg.rolback();
            throw new ExcepcionManager(e);
        }finally {
            mg.commit();
        }
        return mensaje;
    }
}
