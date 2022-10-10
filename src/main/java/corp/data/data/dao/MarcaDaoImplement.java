package corp.data.data.dao;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dto.Marca;
import corp.data.data.excepcion.ExcepcionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarcaDaoImplement implements MarcaDao{

    ManagerConexion conexion = ManagerConexion.getInstance();

    @Override
    public void insert(Marca m) throws ExcepcionDao {
        String INSERT = "insert into marcas(nombre_marca) values(?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(INSERT);
            pstm.setString(1, m.getNombre_marca());
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
    public void update(Marca m) throws ExcepcionDao {
        String UPDATE = "update marcas set nombre_marca = ? where codigo_marca = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(UPDATE);
            pstm.setString(1, m.getNombre_marca());
            pstm.setInt(2, m.getCodigo_marca());
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
    public void delete(Marca m) throws ExcepcionDao {
        String DELETE = "delete from marcas where codigo_marca = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(DELETE);
            pstm.setInt(1, m.getCodigo_marca());
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

    public Marca getByName(String nombre) throws ExcepcionDao {
        String SELECTBYNAME = "select * from marcas where nombre_marca = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Marca _marca_find = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYNAME);
            pstm.setString(1, nombre);
            rs = pstm.executeQuery();

            while (rs.next()){
                _marca_find = new Marca();
                _marca_find.setCodigo_marca(rs.getInt("codigo_marca"));
                _marca_find.setNombre_marca(rs.getString("nombre_marca"));
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

        return _marca_find;
    }

    @Override
    public Marca getById(int codigo) throws ExcepcionDao {
        String SELECTBYID = "select * from marcas where codigo_marca = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Marca _marca_find = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();

            while (rs.next()){
                _marca_find = new Marca();
                _marca_find.setCodigo_marca(rs.getInt("codigo_marca"));
                _marca_find.setNombre_marca(rs.getString("nombre_marca"));
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

        return _marca_find;
    }
}
