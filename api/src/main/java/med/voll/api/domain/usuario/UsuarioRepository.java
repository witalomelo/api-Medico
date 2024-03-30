package med.voll.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //repositorio de dados JPA para entidade Usuario
    //JpaRepository fornece metodos CRUDS para operações no DB da entidade Usuario
    UserDetails findByLogin(String login); //metodo que vai fazer uma consulta no DB
}
