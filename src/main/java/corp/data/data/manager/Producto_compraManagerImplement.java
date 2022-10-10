package corp.data.data.manager;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dao.Producto_compraDao;
import corp.data.data.dao.Producto_compraDaoImplement;
import corp.data.data.dto.Producto_compra;
import corp.data.data.excepcion.ExcepcionDao;
import corp.data.data.excepcion.ExcepcionManager;

public class Producto_compraManagerImplement implements Producto_compraManager {


    Producto_compraDao dao = new Producto_compraDaoImplement();
    ManagerConexion mg = ManagerConexion.getInstance();

    @Override
    public void save(Producto_compra pc) throws ExcepcionManager {
        mg.open();
        try {
            Producto_compra pc_find = dao.getById(pc.getId_prod_compra());
            if(pc_find == null){
                dao.insert(pc);
            }else {
                dao.update(pc);
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

    }

    @Override
    public void remove(Producto_compra pc) throws ExcepcionManager {
        mg.open();
        try {
            Producto_compra pc_find = dao.getById(pc.getId_prod_compra());
            if(pc_find != null){
                dao.insert(pc);
                mg.commit();
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
    }
}
