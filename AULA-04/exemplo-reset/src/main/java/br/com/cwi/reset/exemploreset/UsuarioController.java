package br.com.cwi.reset.exemploreset;

import br.com.cwi.reset.exemploreset.Domain.Usuario;
import br.com.cwi.reset.exemploreset.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getListaUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuairo(@PathVariable("id") Integer idDeletar){
        usuarioService.deleatarUsuario(idDeletar);

    }

}
