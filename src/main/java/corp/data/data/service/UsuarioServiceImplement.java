package corp.data.data.service;

import corp.data.data.dao.UsuarioDao;
import corp.data.data.dto.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UsuarioServiceImplement implements UsuarioService{

    private final Logger log = LoggerFactory.getLogger(UsuarioServiceImplement.class);

    @Autowired
    private UsuarioDao dao;

    @Override
    public void save(Usuario usuario) {
        dao.save(usuario);
    }
}
