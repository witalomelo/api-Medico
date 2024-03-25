package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

//Essa interface é uma abstração que define um conjunto de métodos para acessar e manipular dados em um banco de dados
//JpaRepository fornece metodos como save(), findById(), findAll(), deleteById()
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
