package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

//Essa interface é uma abstração que define um conjunto de métodos para acessar e manipular dados em um banco de dados
//JpaRepository fornece metodos como save(), findById(), findAll(), deleteById()
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    //motando a query
    @Query("""
            select m from Medico m
            where
            m.ativo = 1
            and
            m.especialide = :especialidade
            and 
            m.id not in(
                select c.medico from Consulta c
                where
                c.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
}
