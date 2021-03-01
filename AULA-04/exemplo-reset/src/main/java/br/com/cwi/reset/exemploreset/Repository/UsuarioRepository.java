package br.com.cwi.reset.exemploreset.Repository;


import br.com.cwi.reset.exemploreset.Domain.Usuario;
import br.com.cwi.reset.exemploreset.Exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static Integer id=1;

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setId(id);
        id++;
        usuarios.add(usuario);
        return usuario;
    }

    public void deletarUsuario(Integer idDeletar) {
        Usuario usuarioDeletado=null;

        for(Usuario usuario : usuarios){
            if(usuario.getId()==idDeletar) {
                usuarioDeletado = usuario;
            }
        }
        if(usuarioDeletado==null){
            throw new BadRequestException();
        }
        usuarios.remove(usuarioDeletado);
    }
}
