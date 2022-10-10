package corp.data.data.manager;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dao.ClienteDao;
import corp.data.data.dao.ClienteDaoImplement;
import corp.data.data.dto.Cliente;
import corp.data.data.excepcion.ExcepcionDao;
import corp.data.data.excepcion.ExcepcionManager;

import java.util.List;

public class ClienteManagerImplement implements ClienteManager {

    ClienteDao dao = new ClienteDaoImplement();


    @Override
    public String save(Cliente c) throws ExcepcionManager {
        ManagerConexion mg = ManagerConexion.getInstance();
        mg.open();
        String mensaje = "";
        try {
            Cliente c_find = dao.getById(c.getIdentificacion_cliente());
            if(c_find == null){
                dao.insert(c);
                mensaje = "El cliente se a registrado correctamente";
            }else {
                dao.update(c);
                mensaje = "El cliente se a actualizado correctamente";
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
    public String remove(Cliente c) throws ExcepcionManager {
        ManagerConexion mg = ManagerConexion.getInstance();
        mg.open();
        String mensaje = "";
        try {
            Cliente c_find = dao.getById(c.getIdentificacion_cliente());
            if(c_find != null){
                dao.delete(c);
                mensaje = "El cliente se a eliminado correctamente";
                mg.commit();
            }else {
                mensaje = "No se econtro un cliente con ese id";
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

    @Override
    public List<Cliente> listado() throws ExcepcionManager {
        ManagerConexion mg = ManagerConexion.getInstance();
        mg.open();

        try {
           return  dao.listado();
        } catch (ExcepcionDao e) {
            mg.rolback();
            throw new ExcepcionManager(e);
        }catch (Exception e){
            mg.rolback();
            throw new ExcepcionManager(e);
        }finally {
            mg.close();
        }

    }
}
