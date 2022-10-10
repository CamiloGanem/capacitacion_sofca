package corp.data.data.manager;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dao.ProductoDao;
import corp.data.data.dao.ProductoDaoImplement;
import corp.data.data.dto.Producto;
import corp.data.data.excepcion.ExcepcionDao;
import corp.data.data.excepcion.ExcepcionManager;

public class ProductoManagerImplement implements ProductoManager {


    ProductoDao dao = new ProductoDaoImplement();
    ManagerConexion mg = ManagerConexion.getInstance();

    @Override
    public String save(Producto p) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Producto p_find = dao.getById(p.getCodigo_prod());
            if(p_find == null){
                dao.insert(p);
                mensaje = "El producto sea registrado correctamente";
            }else {
                dao.update(p);
                mensaje = "El producto sea actualizado correctamente";
            }
            mg.commit();
        }
        catch (ExcepcionDao e) {
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
    public String remove(Producto p) throws ExcepcionManager {
        mg.open();
        String mensaje = "";
        try {
            Producto p_find = dao.getById(p.getCodigo_prod());
            if(p_find != null){
                dao.delete(p);
                mensaje = "El producto sea eliminado correctamente";
            }else {
                mensaje = "El producto no existe";
            }
            mg.commit();
        }
        catch (ExcepcionDao e) {
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
