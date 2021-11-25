package corp.data.data.dao;

import corp.data.data.dto.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UsuarioDaoImplement implements UsuarioDao{

    private static final String INSERT = "INSERT INTO usuario(name, email) VALUES(?,?)";
    JdbcTemplate jdbcTemplate;

    public UsuarioDaoImplement(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Usuario usuario) {
        jdbcTemplate.update(INSERT, usuario.getName(), usuario.getEmail());
    }
}
