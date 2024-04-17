package med.voll.api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//UserDetailsService -> interface que define método para carregar detalhes de um usuário por meio do nome
@Service
public class AutenticacaoService implements UserDetailsService {

    //Esta classe terá o código com a lógica de autenticação

    @Autowired
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //metodo que vai utilizar o respository para realizar o select no DB
        return repository.findByLogin(username);
    }
}
