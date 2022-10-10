package corp.data.data.dao;

import corp.data.data.bd.ManagerConexion;
import corp.data.data.dto.Cliente;
import corp.data.data.excepcion.ExcepcionDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImplement implements ClienteDao{

    ManagerConexion conexion = ManagerConexion.getInstance();

    @Override
    public void insert(Cliente c) throws ExcepcionDao {
        String INSERT = "insert into clientes(identificacion_cliente, nombre_cliente, apellido1_cliente, " +
                        "apellido2_cliente, correo_cliente, direccion_cliente) " +
                        "values(?,?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(INSERT);
            pstm.setInt(1, c.getIdentificacion_cliente());
            pstm.setString(2, c.getNombre_cliente());
            pstm.setString(3, c.getApellido1_cliente());
            pstm.setString(4, c.getApellido2_cliente());
            pstm.setString(5, c.getCorreo_cliente());
            pstm.setString(6, c.getDireccion_cliente());

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
    public void update(Cliente c) throws ExcepcionDao {
        String UPDATE = "update clientes set nombre_cliente = ?, apellido1_cliente = ?, apellido2_cliente = ?, " +
                        "correo_cliente = ?, direccion_cliente = ? where identificacion_cliente = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(UPDATE);
            pstm.setString(1, c.getNombre_cliente());
            pstm.setString(2, c.getApellido1_cliente());
            pstm.setString(3, c.getApellido2_cliente());
            pstm.setString(4, c.getCorreo_cliente());
            pstm.setString(5, c.getDireccion_cliente());
            pstm.setInt(6, c.getIdentificacion_cliente());

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
    public void delete(Cliente c) throws ExcepcionDao {
        String DELETE = "delete from clientes where identificacion_cliente = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(DELETE);
            pstm.setInt(1, c.getIdentificacion_cliente());
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
    public Cliente getById(int iden) throws ExcepcionDao {
        String SELECTBYID = "select * from clientes where identificacion_cliente = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente _cliente_find = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYID);
            pstm.setInt(1, iden);
            rs = pstm.executeQuery();

            while (rs.next()) {
                _cliente_find = new Cliente();
                _cliente_find.setIdentificacion_cliente(rs.getInt("identificacion_cliente"));
                _cliente_find.setNombre_cliente(rs.getString("nombre_cliente"));
                _cliente_find.setApellido1_cliente(rs.getString("apellido1_cliente"));
                _cliente_find.setApellido2_cliente(rs.getString("apellido2_cliente"));
                _cliente_find.setCorreo_cliente(rs.getString("correo_cliente"));
                _cliente_find.setDireccion_cliente(rs.getString("direccion_cliente"));
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
        return _cliente_find;
    }

    @Override
    public List<Cliente> listado() throws ExcepcionDao {
        String SELECTBYID = "select * from clientes ";
        List<Cliente> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente _cliente_find = null;
        try {
            pstm = conexion.getConexion().getConexion().prepareStatement(SELECTBYID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                _cliente_find = new Cliente();
                _cliente_find.setIdentificacion_cliente(rs.getInt("identificacion_cliente"));
                _cliente_find.setNombre_cliente(rs.getString("nombre_cliente"));
                _cliente_find.setApellido1_cliente(rs.getString("apellido1_cliente"));
                _cliente_find.setApellido2_cliente(rs.getString("apellido2_cliente"));
                _cliente_find.setCorreo_cliente(rs.getString("correo_cliente"));
                _cliente_find.setDireccion_cliente(rs.getString("direccion_cliente"));
                lista.add(_cliente_find);
            }
        } catch (SQLException e) {
            throw new ExcepcionDao(e);
        }finally {
            try {
                rs.close();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

}
