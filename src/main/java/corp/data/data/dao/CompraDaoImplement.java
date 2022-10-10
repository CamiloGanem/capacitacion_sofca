package corp.data.data.dao;

import corp.data.data.bd.ManagerConexion;
import corp.data.data.dto.Compra;
import corp.data.data.excepcion.ExcepcionDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraDaoImplement implements CompraDao {

    ManagerConexion conexion = ManagerConexion.getInstance();

    @Override
    public void insert(Compra c) throws ExcepcionDao {
        String INSERT = "insert into compras(total_compra, iden_cliente) values(?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(INSERT);
            pstm.setDouble(1, c.getTotal_compra());
            pstm.setInt(2, c.getIden_cliente());
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
    public void update(Compra c) throws ExcepcionDao{
        String UPDATE = "update compras set total_compra = ? where codigo_compra = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(UPDATE);
            pstm.setDouble(1, c.getTotal_compra());
            pstm.setInt(2, c.getCodigo_compra());
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
    public void delete(Compra c) throws ExcepcionDao{
        String DELETE = "delete from compras where codigo_compra = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(DELETE);
            pstm.setInt(1, c.getCodigo_compra());
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
    public Compra getById(int codigo) throws ExcepcionDao{
        String SELECTBYID = "select * from compras where codigo_compra = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Compra _compra_find = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()){
                _compra_find = new Compra();
                _compra_find.setCodigo_compra(rs.getInt("codigo_compra"));
                _compra_find.setFecha_compra(rs.getDate("fecha_compra"));
                _compra_find.setTotal_compra(rs.getDouble("total_compra"));
                _compra_find.setIden_cliente(rs.getInt("iden_cliente"));
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

        return _compra_find;
    }
}
