package br.com.cwi.reset.exemploreset.Services;

import br.com.cwi.reset.exemploreset.Domain.Usuario;
import br.com.cwi.reset.exemploreset.Exception.BadRequestException;
import br.com.cwi.reset.exemploreset.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();


    }

    public Usuario criarUsuario(Usuario usuario) {
        if(usuario==null){
            throw new BadRequestException();
        }
        return usuarioRepository.salvarUsuario(usuario);
    }

    public void deleatarUsuario(Integer idDeletar) {
        if (idDeletar==null){
            throw new BadRequestException();
        }
        usuarioRepository.deletarUsuario(idDeletar);
    }
}
