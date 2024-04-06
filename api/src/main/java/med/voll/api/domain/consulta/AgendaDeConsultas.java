package med.voll.api.domain.consulta;


import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import med.voll.api.domain.ValidacaoException;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {

        //verificando se o id paciente é diferente de nulo
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        //devido as regras de negocio a escolha do medico é opcional e caso ocorra o medico escolhido é aleatório
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico informado não existe!");
        }


        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }

    //implementado do metodo para selecionar medico aleatorio
    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

    }

}
