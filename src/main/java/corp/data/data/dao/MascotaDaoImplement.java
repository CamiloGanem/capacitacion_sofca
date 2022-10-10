package corp.data.data.dao;

import corp.data.data.bd.ManagerConexion;
import corp.data.data.dto.Mascota;
import corp.data.data.excepcion.ExcepcionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotaDaoImplement implements MascotaDao{

    ManagerConexion conexion = ManagerConexion.getInstance();

    @Override
    public void insert(Mascota m) throws ExcepcionDao {
        String INSERT = "insert into mascotas(nombre_masco) values(?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(INSERT);
            pstm.setString(1, m.getNombre_masco());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Mascota m) throws ExcepcionDao {
        String UPDATE = "update mascotas set nombre_masco = ? where codigo_masco = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(UPDATE);
            pstm.setString(1, m.getNombre_masco());
            pstm.setInt(2, m.getCodigo_masco());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Mascota m) throws ExcepcionDao {
        String DELETE = "delete from mascota where codigo_masco = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(DELETE);
            pstm.setInt(1, m.getCodigo_masco());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Mascota getById(int codigo) throws ExcepcionDao {
        String SELECTBYID = "select * from mascotas where codigo_masco = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Mascota _mascota_find = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();

            while (rs.next()){
                _mascota_find = new Mascota();
                _mascota_find.setCodigo_masco(rs.getInt("codigo_masco"));
                _mascota_find.setNombre_masco(rs.getString("nombre_masco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return _mascota_find;
    }
}
