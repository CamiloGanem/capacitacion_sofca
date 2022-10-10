package corp.data.data.dao;


import corp.data.data.bd.ManagerConexion;
import corp.data.data.dto.Producto_compra;
import corp.data.data.excepcion.ExcepcionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Producto_compraDaoImplement implements Producto_compraDao{

    ManagerConexion conexion = ManagerConexion.getInstance();

    @Override
    public void insert(Producto_compra pc) throws ExcepcionDao {
        String INSERT = "insert into productos_compras(cod_producto, cod_compra, cantidad_prod_compra) " +
                        "values(?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(INSERT);
            pstm.setInt(1, pc.getCod_producto());
            pstm.setInt(2, pc.getCod_compra());
            pstm.setInt(3, pc.getCantidad_prod_compra());
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
    public void update(Producto_compra pc) throws ExcepcionDao {
        String UPDATE = "update productos_compras set cantidad_prod_compra where id_prod_compra = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(UPDATE);
            pstm.setInt(1, pc.getId_prod_compra());
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
    public void delete(Producto_compra pc) throws ExcepcionDao {
        String DELETE = "delete from productos_compras where id_prod_compra = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(DELETE);
            pstm.setInt(1, pc.getId_prod_compra());
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
    public Producto_compra getById(int codigo) throws ExcepcionDao {
        String SELECTBYID = "select * from productos_compras where id_prod_compra = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Producto_compra _pc_find = null;

        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();

            while (rs.next()){
                _pc_find = new Producto_compra();
                _pc_find.setId_prod_compra(rs.getInt("id_prod_compra"));
                _pc_find.setCod_producto(rs.getInt("cod_producto"));
                _pc_find.setCod_compra(rs.getInt("cod_compra"));
                _pc_find.setCantidad_prod_compra(rs.getInt("cantidad_prod_compra"));
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
        return _pc_find;
    }
}
