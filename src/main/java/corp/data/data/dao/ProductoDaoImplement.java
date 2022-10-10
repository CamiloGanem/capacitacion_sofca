package corp.data.data.dao;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dto.Producto;
import corp.data.data.excepcion.ExcepcionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDaoImplement implements ProductoDao{

    ManagerConexion conexion = ManagerConexion.getInstance();

    @Override
    public void insert(Producto p) throws ExcepcionDao {
        String INSERT = "insert into productos(nombre_prod, descripcion_prod, imagen_prod, precio_prod, cantidad_prod, " +
                        "cod_marca, tipo_masco) " +
                        "values(?,?,?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(INSERT);
            pstm.setString(1, p.getNombre_prod());
            pstm.setString(2, p.getDescripcion_prod());
            pstm.setString(3, p.getImagen_prod());
            pstm.setDouble(4, p.getPrecio_prod());
            pstm.setInt(5, p.getCantidad_prod());
            pstm.setInt(6, p.getCod_marca());
            pstm.setInt(7, p.getTipo_masco());

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
    public void update(Producto p) throws ExcepcionDao {
        String UPDATE = "update productos set nombre_prod = ?, descripcion_prod = ?, imagen_prod = ?, precio_prod = ?, " +
                        "cantidad_prod = ?, cod_marca = ?, tipo_masco = ? " +
                        "where codigo_prod = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(UPDATE);
            pstm.setString(1, p.getNombre_prod());
            pstm.setString(2, p.getDescripcion_prod());
            pstm.setString(3, p.getImagen_prod());
            pstm.setDouble(4, p.getPrecio_prod());
            pstm.setInt(5, p.getCantidad_prod());
            pstm.setInt(6, p.getCod_marca());
            pstm.setInt(7, p.getTipo_masco());
            pstm.setInt(8, p.getCodigo_prod());

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
    public void delete(Producto p) throws ExcepcionDao {
        String DELETE = "delete from productos where codigo_prod = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(DELETE);
            pstm.setInt(1, p.getCodigo_prod());
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
    public Producto getById(int codigo) throws ExcepcionDao {
        String SELECTBYID = "select * from productos where codigo_prod = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Producto _producto_find = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();

            while (rs.next()){
                _producto_find = new Producto();
                _producto_find.setCodigo_prod(rs.getInt("codigo_prod"));
                _producto_find.setNombre_prod(rs.getString("nombre_prod"));
                _producto_find.setDescripcion_prod(rs.getString("descripcion_prod"));
                _producto_find.setImagen_prod(rs.getString("imagen_prod"));
                _producto_find.setPrecio_prod(rs.getDouble("precio_prod"));
                _producto_find.setCod_marca(rs.getInt("cod_marca"));
                _producto_find.setTipo_masco(rs.getInt("tipo_masco"));
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
        return _producto_find;
    }
}
