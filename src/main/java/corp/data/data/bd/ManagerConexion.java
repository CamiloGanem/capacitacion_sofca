package corp.data.data.bd;

import java.sql.SQLException;

public class ManagerConexion {
    private static ManagerConexion instance;
    public Conexion conexion;

    private ManagerConexion(){
        conexion=new  Conexion();
        conexion.open();
    }

    public static ManagerConexion getInstance(){
        if(instance == null){
            instance = new ManagerConexion();
            return instance;
        }
        return instance;
    }

    public void open(){
        conexion.open();
    }

    public Conexion getConexion(){
        return conexion;
    }

    public void commit(){
        try {
            conexion.getConexion().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rolback(){
        try {
            conexion.getConexion().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            conexion.getConexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
