package corp.data.data.controller;

import corp.data.data.dto.Usuario;
import corp.data.data.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class ControllerPrueba {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email){

        Usuario usuario = new Usuario();
        usuario.setName(name);
        usuario.setEmail(email);

        usuarioService.save(usuario);
        return "saved";
    }

    @PostMapping(path = "/addJson")
    public ResponseEntity<Usuario> addNewUser (@RequestBody Usuario us){
        usuarioService.save(us);
        return ResponseEntity.ok(us);
    }
}
